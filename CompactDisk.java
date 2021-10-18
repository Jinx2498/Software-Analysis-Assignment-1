import java.time.LocalDate;

public class CompactDisk extends Item{

    private String bandName;
    private String recordLabel;

    public CompactDisk(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName, String recordLabel) {

        super(title, regularPrice, releaseDate, quantity);
        this.bandName = bandName;
        this.recordLabel = recordLabel;
        
    }

    // public CompactDisk(String bandName) {


        
    // }

    public CompactDisk(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName, String recordLabel, int itemID) {

        super(title, regularPrice, releaseDate, quantity);
        this.bandName = bandName;
        this.recordLabel = recordLabel;
        
    }

    @Override
    public String toString() {

        return super.toString() + "\n\tBand: " + this.bandName + "\n\tBand: " + this.recordLabel;

    }

    @Override
    public Item makeCopy(Item item) {

        Item copy = new Item(item.getTitle(), item.getRegularPrice(), item.getReleaseDate(), item.getQuantity(), item.getItemID());

        return copy;

    }
    
}
