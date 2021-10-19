import java.time.LocalDate;

public class Game extends Item {

    private String studio;
    private boolean discontinued;

    public Game(String title, double regularPrice, LocalDate releaseDate, int quantity, String studio, boolean discontinued) {
        super(title, regularPrice, releaseDate, quantity);
        this.studio = studio;
        this.discontinued = discontinued;
    }

    public Game(String title, double regularPrice, LocalDate releaseDate, int quantity, String studio, boolean discontinued, int itemID) {
        super(title, regularPrice, releaseDate, quantity, itemID);
        this.studio = studio;
        this.discontinued = discontinued;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tStudio: \n" + studio +
                "\n\tDiscontinued: \n" + discontinued;
    }

    @Override
    public double getPrice(LocalDate sellDate) {
        if(isDiscontinued()) {
            regularPrice = regularPrice * 20;
            return regularPrice;
        } else {
            return regularPrice;
        }
    }

    @Override
    public Item makeCopy() {
        Item game = new Game(getTitle(), getRegularPrice(), getReleaseDate(), getQuantity(), studio, discontinued, getItemID()); 
        return game;
    }
}
