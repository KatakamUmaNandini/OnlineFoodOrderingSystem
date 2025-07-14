public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Cannot proceed to checkout.");
            return;
        }
        cart.displayCart();
        System.out.println("Order placed successfully. Thank you for ordering!");
    }
}
