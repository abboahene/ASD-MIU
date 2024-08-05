package orderSystem;

import orderSystem.visitor.Visitor;

import java.time.LocalDate;

public class IndividualOrder extends Order {

    private String name;

    public IndividualOrder(LocalDate date, double amount, String state, String name) {
        super(date, amount, state);
        this.name = name;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
