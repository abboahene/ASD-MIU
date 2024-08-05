package orderSystem;

import orderSystem.visitor.Visitor;

import java.time.LocalDate;

public class InternalOrder extends Order{

    private String department;

    public InternalOrder(LocalDate date, double amount, String state, String department) {
        super(date, amount, state);
        this.department = department;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
