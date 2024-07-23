package dao;

import domain.Book;
import domain.Cart;
import domain.Customer;

import java.util.HashMap;
import java.util.Map;

public class CartDAO {
    private Map<String, Cart> carts = new HashMap<>();

    public String createCart(Customer customer) {
        carts.put(customer.getEmail(), new Cart(customer));
        return customer.getEmail();
    }

    public void addToCart(String cartId, Book book, int quantity) {
        Cart cart = carts.get(cartId);
        if (cart != null) {
            cart.addCartItem(book, quantity);
        }
    }

    public void removeFromCart(String cartId, Book book) {
        Cart cart = carts.get(cartId);
        if (cart != null) {
            cart.removeCartItem(book);
        }
    }

    public void changeQuantity(String cartId, Book book, int quantity) {
        Cart cart = carts.get(cartId);
        if (cart != null) {
            cart.changeQuantity(book, quantity);
        }
    }

    public Cart getCart(String cartId) {
        return carts.get(cartId);
    }
}