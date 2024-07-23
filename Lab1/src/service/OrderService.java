package service;

import dao.OrderDAO;
import domain.Cart;
import domain.Customer;
import domain.Order;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public Order placeOrder(Cart cart,  String shippingAddress, String billingAddress) {
        Order order = new Order(shippingAddress, billingAddress, cart);
        return orderDAO.saveOrder(order);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}