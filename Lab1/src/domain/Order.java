package domain;

import java.time.LocalDateTime;

public class Order {

    private String shippingAddress;
    private String billingAddress;
    private String status;
    private double totalAmount;
    private LocalDateTime orderDate;
    private Customer customer;
    private Cart cart;

    public Order(String shippingAddress, String billingAddress, Cart cart) {
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.status = "ordered";
        this.totalAmount = calculateTotalAmount(cart);
        this.orderDate = LocalDateTime.now();
        this.customer = cart.getCustomer();
        this.cart = cart;
    }

    private double calculateTotalAmount(Cart cart){
        double total = 0;
        for(CartItem item : cart.getCartItems()){
            int quantity = item.getQuantity();
            double price = item.getBook().getPrice();
            total += (quantity * price);
        }
        return  total;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Details:\n")
                .append("---------------\n")
                .append("Shipping Address: ").append(shippingAddress).append("\n")
                .append("Billing Address: ").append(billingAddress).append("\n")
                .append("Status: ").append(status).append("\n")
                .append("Total Amount: $").append(String.format("%.2f", totalAmount)).append("\n")
                .append("Order Date: ").append(orderDate).append("\n\n")
                .append("Customer Details:\n")
                .append("Name: ").append(customer.getName()).append("\n")
                .append("Phone: ").append(customer.getPhone()).append("\n")
                .append("Email: ").append(customer.getEmail()).append("\n\n")
                .append("Cart Items:\n");

        for (CartItem item : cart.getCartItems()) {
            sb.append(item);
        }

        return sb.toString();
    }
}
