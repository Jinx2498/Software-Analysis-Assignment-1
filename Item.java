import java.time.LocalDate;
import java.time.Period;

public class Item {

    private String title;
    protected double regularPrice;
    private int itemID;
    protected double discount = 0;
    private LocalDate releaseDate;
    private int quantity;
    private int currentItemID = 9000;

    public Item(String title, double regularPrice, LocalDate releaseDate, int quantity) {

        this.title = title;
        this.regularPrice = regularPrice;
        this.releaseDate = releaseDate;
        if (quantity >= 0 && quantity <= 100) {
            this.quantity = quantity;
        } else if (quantity > 100) {
            this.quantity = 100;
        }
        this.itemID = currentItemID;
        currentItemID += 100;


    }

    public Item(String title, double regularPrice, LocalDate releaseDate, int quantity, int itemID) {

        this.title = title;
        this.regularPrice = regularPrice;
        this.releaseDate = releaseDate;
        if (quantity >= 0 && quantity <= 100) {
            this.quantity = quantity;
        } else if (quantity > 100) {
            this.quantity = 100;
        }
        this.itemID = itemID;

    }

    public int getItemID() {

        return this.itemID;

    }

    public String getTitle() {

        return this.title;

    }

    public LocalDate getReleaseDate() {

        return this.releaseDate;

    }

    public double getRegularPrice() {

        return this.regularPrice;

    }

    public double getDiscount() {

        return this.discount;

    }

    public int getQuantity() {

        return this.quantity;

    }

    public double getPrice(LocalDate sellDate) {

        Period period = Period.between(releaseDate, sellDate);
        int difference = period.getYears();
        if(difference > 1) {
            this.regularPrice -= this.regularPrice * 0.5 ;
            this.regularPrice -= this.regularPrice * this.discount;
        } else {
            this.regularPrice -= this.regularPrice * this.discount;
        }

        return this.regularPrice;


    }

    public boolean setDiscount(double discount) {



    }

    public double sell(int amount, LocalDate sellDate) {

        if(sellDate.compareTo(this.releaseDate) < 0) {
            return 0;
        } 
        if(amount > 0 && amount <= this.quantity) {

            this.quantity -= 1;
            return getPrice(sellDate);

        } else {

            return 0;

        }
        

    }

    public boolean addStock(int amount) {


        if((this.quantity + amount) > 100) {
            return false;
        } else {
            this.quantity += amount;
            return true;
        }

    }

    @Override
    public String toString() {

        return "Item " + this.itemID + " :\n" + "\tTitle: " + this.title + "\n" + "\tRegular Price: " + this.regularPrice + "\n" + "\tRelease Date: " + this.releaseDate + "\n" + "\tDiscount: " + this.discount + "\n" + "\tQuantity: " + this.quantity; 

    }

    public Item makeCopy() {

    }

}
