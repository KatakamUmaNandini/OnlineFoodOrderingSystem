package models;
//import services.*;

public class Item {
    private int id;
    private String name;
    private String category;
    private double price;

    public Item(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public Item(int id, String name, double price ){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // ✅ Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    // ✅ Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }

    public String toString(){
        return id + "-" + name + ":" + price;
    }
}