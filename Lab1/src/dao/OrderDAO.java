package dao;

import domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private List<Order> orders = new ArrayList<>();

    public Order saveOrder(Order order) {
        orders.add(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}
