import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class TestBook {
    Book book;
    ArrayList<String> authors;

    @BeforeEach
    void setUp() {
        authors = new ArrayList<>();
        authors.add("Hassan");
        authors.add("Henry");
        authors.add("Cassidy");
        book = new Book("Hospital Sick", 78.99, LocalDate.of(2021, 10, 18), 50, authors);
    }

    @Test
    void BookTest() {
        ArrayList<String> authors = new ArrayList<>();
        authors.add("Ahmad");
        Book bookTest = new Book("Bruh", 15.0, LocalDate.of(2021, 10, 17), 100, authors);
        assertEquals(Arrays.toString(authors.toArray()), Arrays.toString(bookTest.getAuthors().toArray()));
        Book deepBook = new Book(bookTest.getTitle(), bookTest.getRegularPrice(), bookTest.getReleaseDate(), bookTest.getQuantity(), bookTest.getAuthors(), bookTest.getItemID());
        assertEquals(Arrays.toString(bookTest.getAuthors().toArray()), Arrays.toString(deepBook.getAuthors().toArray()));
        assertEquals(bookTest.getTitle(), deepBook.getTitle());
        assertEquals(bookTest.getRegularPrice(), deepBook.getRegularPrice());
        assertEquals(bookTest.getReleaseDate(), deepBook.getReleaseDate());
        assertEquals(bookTest.getQuantity(), deepBook.getQuantity());
    }

    @Test
    void makeCopy() {
        Book bookTest = new Book("Test", 10.0, LocalDate.of(2021, 10, 17), 100, authors);
        Book deepBook = (Book) bookTest.makeCopy();
        assertEquals(bookTest.getTitle(), deepBook.getTitle());
        assertEquals(bookTest.getRegularPrice(), deepBook.getRegularPrice());
        assertEquals(bookTest.getReleaseDate(), deepBook.getReleaseDate());
        assertEquals(bookTest.getQuantity(), deepBook.getQuantity());
        assertNotSame(bookTest, deepBook);
    }

    @Test
    void getPrice() {
        assertEquals(book.getPrice(book.getReleaseDate()), book.getRegularPrice());
        assertEquals(book.getPrice(LocalDate.of(2022, 10, 18)), book.getRegularPrice());
    }

    @Test
    void getAuthors() {
        assertEquals(Arrays.toString(authors.toArray()), Arrays.toString(book.getAuthors().toArray()));
    }
}