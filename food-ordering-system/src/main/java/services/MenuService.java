package services;

import models.Item;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<Item> menu = new ArrayList<>();
    private int itemId = 1;

    public MenuService() {
        addItem("Burger", "Fast Food", 99.0, "https://cdn.pixabay.com/photo/2014/10/23/18/05/burger-500054_1280.jpg");
        addItem("Pizza", "Italian", 199.0, "/Pizza.jpg");
        addItem("Fries", "Snacks", 49.0, "https://cdn.pixabay.com/photo/2016/03/05/19/02/french-fries-1238246_1280.jpg");
        addItem("Pasta", "Italian", 149.0, "/pastha[1].jpg");
        addItem("Noodles", "Chinese", 120.0, "/noodles[1].jpg");
        addItem("Sandwich", "Breakfast", 89.0, "/sandwich.jpg");
        addItem("Dosa", "Breakfast", 49.0, "/dosa[1].jpg");
    }

    public void addItem(String name, String category, double price, String imageUrl) {
        menu.add(new Item(itemId++, name, category, price, imageUrl));
    }

    public List<Item> getMenu() {
        return menu;
    }
}
