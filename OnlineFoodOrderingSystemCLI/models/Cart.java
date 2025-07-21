package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(int itemId) {
        items.removeIf(item -> item.getId() == itemId);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return items.stream().mapToDouble(i -> i.getPrice()).sum();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart Items:\n");
        for (Item item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total: ").append(getTotal());
        return sb.toString();
    }
}