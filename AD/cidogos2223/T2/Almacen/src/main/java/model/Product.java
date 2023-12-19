package model;

public class Product {

    private String title,description;
    private double price;
    private int stock;

    public Product(String title, String description, double price, int stock) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
