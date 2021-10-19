import java.time.LocalDate;
import java.util.ArrayList;

public class Book extends Item {

    private ArrayList<String> authors;

    public Book(String title, double regularPrice, LocalDate releaseDate, int quantity, ArrayList<String> authors) {
        super(title, regularPrice, releaseDate, quantity);
        this.authors = authors;
    }

    public Book(String title, double regularPrice, LocalDate releaseDate, int quantity, ArrayList<String> authors, int itemID) {
        super(title, regularPrice, releaseDate, quantity, itemID);
        this.authors = authors;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tAuthors: \n" +
                authors.toString().replace("[", "\t\t").replace(", ", "").replace("]", "\n");
    }

    @Override
    public double getPrice(LocalDate sellDate) {
        regularPrice -= regularPrice * discount;
        return regularPrice;
    }

    @Override
    public Book makeCopy() {
        return new Book(getTitle(), getRegularPrice(), getReleaseDate(), getQuantity(), authors, getItemID());
    }
}
