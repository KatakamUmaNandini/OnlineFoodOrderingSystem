package services;

import models.Order;
import models.Cart;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void placeOrder(String username, Cart cart) {
        orders.add(new Order(username, cart.getItems(), cart.getTotal()));
    }

    public List<Order> getOrders() {
        return orders;
    }
}