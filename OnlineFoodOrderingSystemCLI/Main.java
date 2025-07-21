import models.*;
import services.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        UserService userService = new UserService();
        MenuService menuService = new MenuService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();
        AdminService adminService = new AdminService(menuService);
        ItemService itemService = new ItemService();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Online Food Order System!");
        while(true){
            System.out.println("Enter e to Exit app");
            System.out.print("Are you admin or user? (a/u/e): ");
            String role = sc.next();

            if (role.equals("a")) {
                System.out.print("Admin Mode. Enter password: ");
                if (sc.next().equals("admin123")) {
                    while (true) {
                        System.out.println("\n1. View Menu\n2. Add Item\n3. Remove Item\n4. Search Items\n5. View Orders\n6. Exit");
                        int c = sc.nextInt();
                        if (c == 1) {
                            for (Item item : menuService.getMenu()) System.out.println(item);
                        }
                        else if (c == 2) {
                            System.out.print("Enter name & price: ");
                            String name = sc.next();
                            double price = sc.nextDouble();
                            adminService.addItem(name, price);
                        } else if (c == 3) {
                            System.out.print("Enter item ID to remove: ");
                            int id = sc.nextInt();
                            adminService.removeItem(id);
                        } else if(c == 4){
                            System.out.print("Enter an item name to search: ");
                            String keyword = sc.next();
                            List<Item> list = itemService.searchItems(keyword);
                            for (Item item : list) System.out.println(item);
                        }else if (c == 5) {
                            for (Order o : orderService.getOrders()) System.out.println(o);
                        } else break;
                    }
                }
            } else if(role.equals("u")){
                System.out.print("1. Register\n2. Login: ");
                int opt = sc.nextInt();
                System.out.print("Username: ");
                String username = sc.next();
                System.out.print("Password: ");
                String password = sc.next();

                if (opt == 1) {
                    if (userService.register(username, password)) {
                        System.out.println("Registered successfully.");
                    } else {
                        System.out.println("Username already exists.");
                        return;
                    }
                }

                if (!userService.login(username, password)) {
                    System.out.println("Invalid credentials.");
                    return;
                }

                while (true) {
                    System.out.println("\n1. View Menu\n2. View Cart\n3. Search Item\n4. Filter by Category\n5. Filter by Price\n6. Add to Cart\n7. Remove from Cart\n8. Place Order\n10. Exit");
                    int ch = sc.nextInt();
                    if (ch == 1) {
                        for (Item i : menuService.getMenu()) System.out.println(i);
                    } else if (ch == 2) {
                        Cart cart = cartService.viewCart(username);
                        for (Item item : cart.getItems()) System.out.println(item); 
                        System.out.println("Total: " + cart.getTotal());
                    } else if (ch == 3) {
                        System.out.print("Enter an item name to search: ");
                        String keyword = sc.next();
                        List<Item> list = itemService.searchItems(keyword);
                        for (Item item : list) System.out.println(item); 
                    } else if (ch == 4) {
                        System.out.print("Enter the category name: ");
                        String category = sc.next();
                        List<Item> list = itemService.searchItems(category);
                        for (Item item : list) System.out.println(item);
                    } else if (ch == 5) {
                        System.out.print("Sort by price? (asc/desc): ");
                        String sort = sc.next();
                        boolean asc = sort.equalsIgnoreCase("asc");
                        List<Item> sortedItems = menuService.getMenuSortedByPriceUsingMergeSort(asc);
                        for (Item item : sortedItems) System.out.println(item); 
                    } else if(ch == 6){
                        System.out.print("Enter item ID: ");
                        int id = sc.nextInt();
                        Item item = menuService.getItemById(id);
                        if (item != null) cartService.addToCart(username, item);
                    } else if(ch == 7){
                        System.out.print("Enter item ID: ");
                        int id = sc.nextInt();
                        cartService.removeFromCart(username, id);
                    } else if(ch == 8){
                        Cart cart = cartService.getCart(username);
                        orderService.placeOrder(username, cart);
                        System.out.println("Order placed!");
                    } 
                    else break;
                }
            }else{
                System.exit(0);
            }
        }
        //sc.close();
    }
}