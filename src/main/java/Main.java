import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = LibraryPersistence.loadLibrary();
        try {
            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Add a book");
                System.out.println("2. View the catalog");
                System.out.println("3. Exit");

                System.out.print("Choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Enter the details of the book:");
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Publication year: ");
                        int publicationYear = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("ISBN: ");
                        String ISBN = scanner.nextLine();

                        Book book = new Book(title, author, publicationYear, ISBN);
                        library.addBook(book);
                        System.out.println("Book successfully added to the catalog.");
                        LibraryPersistence.saveLibrary(library);
                        break;
                    case 2:
                        System.out.println("Library catalog:");
                        System.out.println(library);
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        return; // Exit the main method
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } finally {
            scanner.close(); // Close the scanner at the end of the main method
        }
    }
}
