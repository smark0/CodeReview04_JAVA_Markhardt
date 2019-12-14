package sample;

public class Product {
    String productName;
    String Quantity;
    double oldPrice;
    double newPrice;
    String imagePath;
    String description;

    @Override
    public String toString() {
        return "{'" +
                productName + '\'' +
                ", old=" + oldPrice +
                ", new=" + newPrice +
                '}';
    }

    public Product(String productName, String quantity, double oldPrice, double newPrice, String imagePath, String description) {
        this.productName = productName;
        Quantity = quantity;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.imagePath = imagePath;
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDescription() {
        return description;
    }
}