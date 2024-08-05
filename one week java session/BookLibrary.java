import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookLibrary {
    private String[] bookTitles;
    private int size;

    public BookLibrary(int capacity) {
        bookTitles = new String[capacity];
        size = 0;
    }

    // Add a Book Title
    public void addBookTitle(String title) {
        if (size == bookTitles.length) {
            bookTitles = Arrays.copyOf(bookTitles, size * 2);
        }
        bookTitles[size++] = title;
    }

    // Remove a Book Title
    public void removeBookTitle(String title) {
        int index = searchBookTitle(title);
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                bookTitles[i] = bookTitles[i + 1];
            }
            bookTitles[size - 1] = null;
            size--;
        }
    }

    // Search for a Book Title
    public int searchBookTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (bookTitles[i].equals(title)) {
                return i;
            }
        }
        return -1;
    }

    // List All Book Titles
    public void listAllBookTitles() {
        for (int i = 0; i < size; i++) {
            System.out.println(bookTitles[i]);
        }
    }

    // Sort Book Titles
    public void sortBookTitles() {
        List<String> list = new ArrayList<>(Arrays.asList(bookTitles));
        list.subList(0, size).sort(null);
        list.toArray(bookTitles);
    }

    public static void main(String[] args) {
        BookLibrary library = new BookLibrary(5);
        
        library.addBookTitle("Old Man and The Sea");
        library.addBookTitle("To Kill a Mockingbird");
        library.addBookTitle("1985");
        library.addBookTitle("The Great Gatsby");

        System.out.println("All Book Titles:");
        library.listAllBookTitles();
        
        System.out.println("\nSorting Book Titles...");
        library.sortBookTitles();
        library.listAllBookTitles();
        
        System.out.println("\nSearching for '1985':");
        int index = library.searchBookTitle("1985");
        System.out.println(index != -1 ? "Found at index: " + index : "Not found");
        
        System.out.println("\nRemoving '1985'...");
        library.removeBookTitle("1985");
        library.listAllBookTitles();
    }
}