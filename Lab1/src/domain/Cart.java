package domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems;
    private Customer customer;

    public Cart(Customer customer) {
        this.cartItems = new ArrayList<>();
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addCartItem(Book book, int quantity) {

        this.cartItems.add(new CartItem(book, quantity));
    }

    public void removeCartItem(Book book) {
            cartItems.removeIf(item -> item.getBook().equals(book));
    }
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    public void checkout(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    public void changeQuantity(Book book, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getBook().equals(book)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItems=" + cartItems +
                '}';
    }
}
