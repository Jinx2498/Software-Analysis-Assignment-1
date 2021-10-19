import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestGame {
    Game game1;
    @BeforeEach
    void setUp() {
        game1 = new Game("Valorant", 19.99, LocalDate.of(2016, 3, 1), 100, "RIOT", false);
    }

    @Test
    void getPrice() {
        assertEquals(19.99, game1.getPrice(LocalDate.now()));
    }

    @Test
    void constructor() {
        assertEquals("Valorant", game1.getTitle());
        assertEquals(19.99, game1.getRegularPrice());
        assertEquals(LocalDate.of(2016, 3, 1), game1.getReleaseDate());
        assertEquals(100, game1.getQuantity());
        assertFalse(game1.isDiscontinued());
    }

    @Test
    void makeCopy() {
        Game copy = (Game) game1.makeCopy();
        assertEquals(copy.getTitle(), game1.getTitle());
        assertEquals(copy.getRegularPrice(), game1.getRegularPrice());
        assertEquals(copy.getReleaseDate(), game1.getReleaseDate());
        assertEquals(copy.getQuantity(), game1.getQuantity());
        assertEquals(copy.isDiscontinued(), game1.isDiscontinued());
        assertNotSame(copy, game1);
    }
}