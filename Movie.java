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
        return super.toString() +
                "\n\tDirector: \n" + director +
                "\n\tProducer: \n" + producer;
    }

    @Override
    public Item makeCopy() {
        return new Movie(getTitle(), getRegularPrice(), getReleaseDate(), getQuantity(), director, producer, getItemID());
    }
}
