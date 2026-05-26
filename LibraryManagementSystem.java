import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String name;
    String author;
    boolean isIssued;

    Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isIssued = false;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // 🔐 Set your password here
    static String password = "admin123";

    // LOGIN METHOD
    public static boolean login() {
        System.out.print("Enter Password: ");
        String input = sc.nextLine();

        if (input.equals(password)) {
            System.out.println("Login Successful!\n");
            return true;
        } else {
            System.out.println("Wrong Password! Access Denied.\n");
            return false;
        }
    }

    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, name, author));
        System.out.println("Book added successfully!\n");
    }

    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.\n");
            return;
        }

        System.out.println("\n--- Book List ---");
        for (Book b : books) {
            System.out.println("ID: " + b.id +
                    ", Name: " + b.name +
                    ", Author: " + b.author +
                    ", Status: " + (b.isIssued ? "Issued" : "Available"));
        }
        System.out.println();
    }

    public static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully!\n");
                } else {
                    System.out.println("Book already issued!\n");
                }
                return;
            }
        }
        System.out.println("Book not found!\n");
    }

    public static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully!\n");
                } else {
                    System.out.println("Book was not issued!\n");
                }
                return;
            }
        }
        System.out.println("Book not found!\n");
    }

    public static void main(String[] args) {

        sc.nextLine(); // clear buffer

        // 🔐 LOGIN FIRST
        if (!login()) {
            return; // stop program if login fails
        }

        while (true) {
            System.out.println("===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }
}