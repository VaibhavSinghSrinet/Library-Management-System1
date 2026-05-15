import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String name;
    boolean isIssued;

    // Constructor
    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.isIssued = false;
    }

    // Display book details
    void display() {
        System.out.println("Book ID: " + id);
        System.out.println("Book Name: " + name);
        System.out.println("Status: " + (isIssued ? "Issued" : "Available"));
        System.out.println();
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Book
    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        books.add(new Book(id, name));

        System.out.println("Book Added Successfully!\n");
    }

    // Show All Books
    static void showBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available!\n");
            return;
        }

        for (Book b : books) {
            b.display();
        }
    }

    // Issue Book
    static void issueBook() {

        System.out.print("Enter Book ID to Issue: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book Issued Successfully!\n");
                } else {
                    System.out.println("Book Already Issued!\n");
                }

                return;
            }
        }

        System.out.println("Book Not Found!\n");
    }

    // Return Book
    static void returnBook() {

        System.out.print("Enter Book ID to Return: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book Returned Successfully!\n");
                } else {
                    System.out.println("Book Was Not Issued!\n");
                }

                return;
            }
        }

        System.out.println("Book Not Found!\n");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    showBooks();
                    break;

                case 3:
                    issueBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!\n");
            }

        } while (choice != 5);
    }
}