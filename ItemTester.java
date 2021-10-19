import java.time.LocalDate;

public class ItemTester {

    public static void main(String[] args) {

        Item item1 = new Item("Destiny 2", 79.99, LocalDate.of(2017, 9, 6), 102);
        Item item2 = new Item("Sekiro", 79.99, LocalDate.of(2019, 3, 22), 30, 1234);

        System.out.println("Price: ");
        System.out.println(item1.getPrice(LocalDate.of(2017, 11, 22)));
        System.out.println(item2.getPrice(LocalDate.of(2020, 3, 25)));

        System.out.println("Discount: ");
        item1.setDiscount(0.2);
        item2.setDiscount(0.6);

        System.out.println(item1.getPrice(LocalDate.of(2017, 11, 22)));
        System.out.println(item2.getPrice(LocalDate.of(2020, 3, 25)));

        System.out.println("Sales: ");
        System.out.println(item1.sell(105, LocalDate.of(2017, 11, 22)));
        System.out.println(item1.sell(0, LocalDate.of(2017, 11, 22)));
        System.out.println(item1.sell(50, LocalDate.of(2016, 11, 22)));
        System.out.println(item2.sell(30, LocalDate.of(2020, 3, 25)));

        System.out.println("Add Stock: ");
        System.out.println(item1.addStock(20));
        System.out.println(item2.addStock(20));
        System.out.println(item2.addStock(80));

    }
    
}
