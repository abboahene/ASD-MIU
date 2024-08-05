package orderSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDate date;
    private double amount;
    private String state;

    private List<Orderline> orderlineList;

    public Order(LocalDate date, double amount, String state) {
        this.date = date;
        this.amount = amount;
        this.state = state;
        this.orderlineList = new ArrayList<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Orderline> getOrderlineList() {
        return orderlineList;
    }

    public void addOrderline(Orderline orderline) {
        this.orderlineList.add(orderline);
    }
}
