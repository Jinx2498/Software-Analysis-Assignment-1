import java.time.LocalDate;

public class Movie extends Item {

    private String director;
    private String producer;

    public Movie(String title, double regularPrice, LocalDate releaseDate, int quantity, String director, String producer) {

        super(title, regularPrice, releaseDate, quantity);
        this.director = director;
        this.producer = producer;
        
    }

    public Movie(String title, double regularPrice, LocalDate releaseDate, int quantity, String director, String producer, int itemID) {

        super(title, regularPrice, releaseDate, quantity, itemID);
        this.director = director;
        this.producer = producer;
        
    }

    @Override
    public String toString() {

        return super.toString() + "\n\tDirector: \n" + this.director + "\n\tProducer: \n" + this.producer; 

    }

    @Override
    public Item makeCopy(Item item) {

        Item copy = new Item(item.getTitle(), item.getRegularPrice(), item.getReleaseDate(), item.getQuantity(), item.getItemID());

        return copy;

    }

}
