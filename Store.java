import java.util.ArrayList;
import java.time.LocalDate;

public class Store {

    private ArrayList<Item> inventory;
    private double totalSalesValue = 0;
    private int totalNumberOfSales = 0;
    
    public Store() {
        inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public boolean makeSale(int itemID, int quantity, LocalDate sellDate) {
        if (getItemByID(itemID) == null) {
            return false;
        } else {
            double value = getItemByID(itemID).sell(quantity, sellDate);
            if (value > 0) {
                totalNumberOfSales += 1;
                totalSalesValue += value;
                return true;
            } else {
                return false;
            }
        }
    }

    public String getInventoryString() {
        String inventoryString = "";
        for (Item item : inventory)  {
            inventoryString = inventoryString.concat("\n" + item.toString() + "\n");
        }
        return inventoryString;
    }

    public void listInventory() {
        System.out.println("Here are all the inventory items: " + getInventoryString());
    }

    public Item checkForItem(int itemID) {
        Item result = null;
        for (Item item : inventory)  {
            if (item.getItemID() == itemID) {
                result = item;
            } else {
                return null;
            }
        }
        return result;
    }

    public Item getItemByID(int itemID) {
        Item result = null;
        for (Item item : inventory)  {
            if(item.getItemID() == itemID) {
                result = item;
            } else {
                result = null;
            }
        }
        return result;
    }

    public double getTotalSalesValue() {
        return totalSalesValue;
    }

    public int getTotalNumberOfSales() {
        return totalNumberOfSales;
    }

    @Override
    public String toString() {
        return "Total Sales Value: " + totalSalesValue + "\n" +
                "Total Number of Sales: " + totalNumberOfSales + "\n" +
                "Current Inventory: \n" + getInventoryString();
    }
} 