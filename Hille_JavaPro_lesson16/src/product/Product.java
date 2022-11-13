package product;

import java.time.LocalDateTime;

public class Product {

    String type;
    double price;
    boolean discount;
    LocalDateTime dateAdd;

    public Product(String type, double price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.dateAdd = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDateTime getDateAdd() {
        return dateAdd;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public static int compare(Product p1, Product p2){
        if(p1.getPrice() > p2.getPrice())
            return 1;
        return -1;
    }

    public static int compareByDate(Product p1, Product p2){
        if (p1.getDateAdd().isBefore(p2.getDateAdd()))
            return 1;
        return -1;
    }
}
