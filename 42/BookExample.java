import java.util.Scanner;

class Book {
    // Instance variables
    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Constructor with title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0.0; // Default price
    }

    // Constructor with title, author, and price
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to print book details
    public void printBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}

public class BookExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for default constructor
        Book book1 = new Book();
        System.out.println("Book 1 (Default Constructor):");
        book1.printBookDetails();
        System.out.println();

        // Taking user input for title and author
        System.out.print("Enter the title of the book: ");
        String title2 = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author2 = scanner.nextLine();
        Book book2 = new Book(title2, author2);
        System.out.println("Book 2 (Title and Author Constructor):");
        book2.printBookDetails();
        System.out.println();

        // Taking user input for title, author, and price
        System.out.print("Enter the title of the book: ");
        String title3 = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author3 = scanner.nextLine();
        System.out.print("Enter the price of the book: ");
        double price3 = scanner.nextDouble();
        Book book3 = new Book(title3, author3, price3);
        System.out.println("Book 3 (Title, Author, and Price Constructor):");
        book3.printBookDetails();
    }
}
