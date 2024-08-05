package orderSystem;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Product TV = new Product("TV", 84.3);
        Product football = new Product("Football", 14.7);

        Orderline orderline1 = new Orderline(TV, 8);
        Orderline orderline2 = new Orderline(football, 10);

        double totalOrderAmount1 = (TV.getPrice() * 8) + (football.getPrice() * 10);
        Order order1 = new CooperateOrder(LocalDate.now(), totalOrderAmount1, "Iowa", "MW Ltd", "+1427842");
        order1.addOrderline(orderline1);
        order1.addOrderline(orderline2);

        Orderline orderline3 = new Orderline(TV, 5);
        Orderline orderline4 = new Orderline(football, 5);

        double totalOrderAmount2 = (TV.getPrice() * 5) + (football.getPrice() * 5);
        Order order2 = new InternalOrder(LocalDate.now(), totalOrderAmount2, "Iowa", "HR");
        order2.addOrderline(orderline3);
        order2.addOrderline(orderline4);

        OrderCollection orderCollection = new OrderCollection();
        orderCollection.addOrder(order1);
        orderCollection.addOrder(order2);


        orderCollection.printOrderTypeCounts();
        orderCollection.printNumberOfTVs();
        orderCollection.printTotalAmount();

    }
}