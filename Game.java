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

        super(title, regularPrice, releaseDate, quantity);
        this.studio = studio;
        this.discontinued = discontinued;
        
    }

    public void setDiscontinued(boolean discontinued) {

        this.discontinued = discontinued;

    }

    public boolean getDiscontinued() {
        
        return this.discontinued;

    }

    @Override
    public String toString() {

        return super.toString() + "\n\tStudio: \n" + this.studio + "\n\tDiscontinued: \n" + this.discontinued; 

    }

    @Override
    public double getPrice(LocalDate sellDate) {

        if(discontinued == true) {

            regularPrice = regularPrice * 20;
            return regularPrice;

        } else {

            return regularPrice;

        }

    }

    @Override
    public Item makeCopy() {

    }

    
}
