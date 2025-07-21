package models;

import java.util.List;

public class Order {
    public String username;
    public List<Item> items;
    public double total;

    public Order(String username, List<Item> items, double total) {
        this.username = username;
        this.items = items;
        this.total = total;
    }

    public String toString() {
        return "User: " + username + " | Total: " + total + " | Items: " + items.size();
    }
}