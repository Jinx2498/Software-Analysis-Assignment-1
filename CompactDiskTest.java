import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCompactDisc {
    CompactDisk compactDisc;

    @Test
    void CompactDiscTest() {
        compactDisc = new CompactDisk("Hell", 45, LocalDate.of(2021, 10, 18), 100, "BRUH", "LOL");
        assertEquals("Hell", compactDisc.getTitle());
        assertEquals(45, compactDisc.getRegularPrice());
        assertEquals(LocalDate.of(2021, 10, 18), compactDisc.getReleaseDate());
        assertEquals(100, compactDisc.getQuantity());
    }

    @Test
    void getPrice() {
        compactDisc = new CompactDisk("Hell Heaven", 50, LocalDate.of(2021, 10, 18), 100, "BRUH", "LOL");
        assertEquals(50.0, compactDisc.getPrice(LocalDate.of(2021, 10, 18)));
    }

    @Test
    void makeCopy() {
        compactDisc = new CompactDisk("Hell Heaven Hell", 30, LocalDate.of(2021, 10, 17), 100, "PAND");
        CompactDisk deepCompactDisc = (CompactDisk) compactDisc.makeCopy();
        assertEquals(deepCompactDisc.getTitle(), compactDisc.getTitle());
        assertEquals(deepCompactDisc.getRegularPrice(), compactDisc.getRegularPrice());
        assertEquals(deepCompactDisc.getReleaseDate(), compactDisc.getReleaseDate());
        assertEquals(deepCompactDisc.getQuantity(), compactDisc.getQuantity());
        assertEquals(deepCompactDisc.getItemID(), compactDisc.getItemID());
    }
}