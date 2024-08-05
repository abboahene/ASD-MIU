package orderSystem;

import orderSystem.visitor.Visitor;

import java.time.LocalDate;

public class CooperateOrder extends Order{
    private String company;
    private String contact;
    public CooperateOrder(LocalDate date, double amount, String state, String company, String contact) {
        super(date, amount, state);
        this.company = company;
        this.contact = contact;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
