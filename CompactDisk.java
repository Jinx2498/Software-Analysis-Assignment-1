import java.time.LocalDate;

public class CompactDisc extends Item{

    private String bandName;
    private String recordLabel;

    public CompactDisc(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName, String recordLabel) {
        super(title, regularPrice, releaseDate, quantity);
        this.bandName = bandName;
        this.recordLabel = recordLabel;
    }

    public CompactDisc(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName) {
        this(title, regularPrice, releaseDate, quantity, bandName, "Indie");
    }

    public CompactDisc(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName, String recordLabel, int itemID) {
        super(title, regularPrice, releaseDate, quantity, itemID);
        this.bandName = bandName;
        this.recordLabel = recordLabel;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBand:\t" + bandName + "\nRecord Label:\t" + recordLabel;
    }

    @Override
    public Item makeCopy() {
        Item disc = new CompactDisc(getTitle(), getRegularPrice(),getReleaseDate(),getQuantity(), bandName, recordLabel, getItemID());
        return disc;
    }
}
