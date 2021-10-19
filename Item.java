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

    public String getTitle() {
        return title;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public double getDiscount() {
        return discount;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice(LocalDate sellDate) {
        Period period = Period.between(releaseDate, sellDate);
        int difference = period.getYears();
        if(difference > 1) {
            return regularPrice * 0.5 * (1 - discount);
        } else {
            return regularPrice * (1 - discount);
        }
    }

    public boolean setDiscount(double discount) {
        if (discount > 0.5) {
            return false;
        }
       this.discount = discount;
       return true;
    }

    public double sell(int amount, LocalDate sellDate) {
        if (sellDate.compareTo(releaseDate) < 0) {
            return 0;
        } 
        if (amount > 0 && amount <= quantity) {
            this.quantity -= amount;
            return regularPrice * amount;
        } else {
            return 0;
        }
    }

    public boolean addStock(int amount) {
        if((quantity + amount) > 100) {
            return false;
        } else {
            quantity += amount;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Item " + itemID + " :\n" +
                "\tTitle: " + title + "\n" +
                "\tRegular Price: " + regularPrice + "\n" +
                "\tRelease Date: " + releaseDate + "\n" +
                "\tDiscount: " + discount + "\n" +
                "\tQuantity: " + quantity;
    }

    public Item makeCopy() {

        Item copy = new Item(getTitle(), getRegularPrice(), getReleaseDate(), getQuantity(), getItemID());

        return copy;

    }
}
