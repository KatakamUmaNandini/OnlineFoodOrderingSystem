package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(int itemId) {
        items.removeIf(item -> item.id == itemId);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return items.stream().mapToDouble(i -> i.price).sum();
    }
}
