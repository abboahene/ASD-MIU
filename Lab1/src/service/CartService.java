package service;

import dao.CartDAO;
import domain.Book;
import domain.Cart;
import domain.Customer;

public class CartService {
    private CartDAO cartDAO = new CartDAO();

    public String createCart(Customer customer) {
        return cartDAO.createCart(customer);
    }

    public void addToCart(String customerId, Book book, int quantity) {
        Cart cart = cartDAO.getCart(customerId);
        if (cart == null) {
            throw new IllegalArgumentException("Cart not found for customer ID: " + customerId);
        }
        cartDAO.addToCart(customerId, book, quantity);
    }

    public void removeFromCart(String customerId, Book book) {
        Cart cart = cartDAO.getCart(customerId);
        if (cart == null) {
            throw new IllegalArgumentException("Cart not found for customer ID: " + customerId);
        }
        cartDAO.removeFromCart(customerId, book);
    }

    public void changeQuantity(String customerId, Book book, int quantity) {
        Cart cart = cartDAO.getCart(customerId);
        if (cart == null) {
            throw new IllegalArgumentException("Cart not found for customer ID: " + customerId);
        }
        cartDAO.changeQuantity(customerId, book, quantity);
    }

    public Cart getCart(String customerId) {
        Cart cart = cartDAO.getCart(customerId);
        if (cart == null) {
            throw new IllegalArgumentException("Cart not found for customer ID: " + customerId);
        }
        return cart;
    }
}