package services;
import models.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemService {
    private List<Item> items;

    public ItemService() {
        items = new ArrayList<>();

        // Sample Items
        items.add(new Item(1, "Burger", "Fast Food", 120.0));
        items.add(new Item(2, "Pizza", "Italian", 250.0));
        items.add(new Item(3, "Sushi", "Japanese", 400.0));
        items.add(new Item(4, "Dosa", "South Indian", 80.0));
    }

    public List<Item> searchItems(String keyword) {
        return items.stream()
                .filter(item -> item.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                                item.getCategory().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Item> filterByCategory(String category) {
        return items.stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    /*public List<Item> filterByPriceRange(double min, double max) {
        return items.stream()
                .filter(item -> item.getPrice() >= min && item.getPrice() <= max)
                .collect(Collectors.toList());
    }*/

    public List<Item> getAllItems() {
        return items;
    }
}