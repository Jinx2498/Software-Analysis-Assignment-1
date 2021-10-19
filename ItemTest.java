import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class TestItem {

    Item item;

    @BeforeEach
    void setUp() {
        item = new Item("Halo", 9.99, LocalDate.of(2020, 2, 23), 80);
    }
    @Test
    void getPrice() {
        assertEquals(9.99, item.getPrice(LocalDate.of(2021, 2, 23)));
    }

    @Test
    void setDiscount() {
        item.setDiscount(0.0);
        assertEquals(0.0, item.getDiscount());
        item.setDiscount(0.6);
        assertEquals(0.0, item.getDiscount());
        item.setDiscount(0.25);
        assertEquals(0.25, item.getDiscount());
        item.setDiscount(0.5);
        assertEquals(0.5, item.getDiscount());
        item.setDiscount(0.0);
        assertEquals(0.0, item.getDiscount());
    }

    @Test
    void sell() {
        double sale = item.sell(1, LocalDate.of(2020, 2, 23));
        assertEquals(9.99, sale);
        sale = item.sell(1, LocalDate.of(2017, 2, 23));
        assertEquals(0, sale);
        sale = item.sell(16, LocalDate.of(2020, 6, 5));
        assertEquals(9.99 * 16, sale);
        sale = item.sell(1, LocalDate.of(2021, 2, 23));
        assertEquals(9.99, sale);

    }

    @Test
    void constructor() {
        item = new Item("CSGO", 9.99, LocalDate.of(2020, 2, 23), 80);
        assertEquals("CSGO", item.getTitle());
        assertEquals(9.99, item.getRegularPrice());
        assertEquals(LocalDate.of(2020, 2, 23), item.getReleaseDate());
        assertEquals(80, item.getQuantity());
        Item copyOfItem = item.makeCopy();
        assertNotSame(copyOfItem, item);
    }

    @Test
    void addStock() {
        assertTrue(item.addStock(10));
        assertEquals(90, item.getQuantity());
        assertTrue(item.addStock(10));
        assertEquals(100, item.getQuantity());
        assertFalse(item.addStock(1));
        assertEquals(100, item.getQuantity());
    }
}