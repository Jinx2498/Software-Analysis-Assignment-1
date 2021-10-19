import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class TestMovie {
    Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie("Delayed Time", 16.99, LocalDate.of(2020, 12, 23), 60, "Jim Brown", "Yolo");
    }
    @Test
    void getPrice() {
        assertEquals(12.99, movie.getPrice(LocalDate.of(2021, 2, 23)));
    }

    @Test
    void constructor() {
        assertEquals("Delayed Time", movie.getTitle());
        assertEquals(16.99, movie.getRegularPrice());
        assertEquals(LocalDate.of(2020, 12, 23), movie.getReleaseDate());
        assertEquals(60, movie.getQuantity());
    }

    @Test
    void makeCopy() {
        Movie copy = (Movie) movie.makeCopy();
        assertEquals(copy.getTitle(), movie.getTitle());
        assertEquals(copy.getRegularPrice(), movie.getRegularPrice());
        assertEquals(copy.getReleaseDate(), movie.getReleaseDate());
        assertEquals(copy.getQuantity(), movie.getQuantity());
        assertEquals(copy.getItemID(), movie.getItemID());
        assertNotSame(copy, movie);
    }
}