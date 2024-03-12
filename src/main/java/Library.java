import java.util.ArrayList;
import java.util.List;

public class Library {
    // Attributes
    private String name;
    private String address;
    private List<Book> catalog;

    // Constructors
    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.catalog = new ArrayList<>();
    }

    public Library(String name, String address, List<Book> catalog) {
        this.name = name;
        this.address = address;
        this.catalog = catalog;
    }

    // Getter and setter methods for each attribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<Book> catalog) {
        this.catalog = catalog;
    }

    // Other methods if necessary
    // ...

    // Method to add a book to the library's catalog
    public void addBook(Book book) {
        catalog.add(book);
    }

    // Method to remove a book from the library's catalog
    public void removeBook(Book book) {
        catalog.remove(book);
    }

    // toString method to get a textual representation of the library
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library: ").append(name).append("\n");
        sb.append("Address: ").append(address).append("\n");
        sb.append("Catalog:\n");

        if (catalog.isEmpty()) {
            sb.append("Empty\n");
        } else {
            for (Book book : catalog) {
                sb.append(book).append("\n");
            }
        }

        return sb.toString();
    }
}
