package services;

import models.Cart;
import models.Item;
import java.util.HashMap;

public class CartService {
    private HashMap<String, Cart> userCarts = new HashMap<>();

    public Cart getCart(String username) {
        return userCarts.computeIfAbsent(username, k -> new Cart());
    }

    public void addToCart(String username, Item item) {
        getCart(username).addItem(item);
    }

    public void removeFromCart(String username, int itemId) {
        getCart(username).removeItem(itemId);
    }
}
