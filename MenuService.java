package services;

import models.Item;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<Item> menu = new ArrayList<>();
    private int itemId = 1;

    public MenuService() {
        addItem("Burger", 99.0);
        addItem("Pizza", 199.0);
        addItem("Fries", 49.0);
    }

    public void addItem(String name, double price) {
        menu.add(new Item(itemId++, name, price));
    }

    public void removeItem(int id) {
        menu.removeIf(item -> item.id == id);
    }

    public List<Item> getMenu() {
        return menu;
    }

    public Item getItemById(int id) {
        for (Item item : menu) {
            if (item.id == id) return item;
        }
        return null;
    }
}
