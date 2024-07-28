package customers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Step2Iterator implements Iterator<Customer> {
    private final List<Customer> customerList;
    private int currIndex;

    public Step2Iterator(List<Customer> customerList) {
        this.customerList = customerList;
        currIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currIndex < customerList.size();
    }

    @Override
    public Customer next() {
        if(!hasNext()) return null;
        Customer customer = customerList.get(currIndex);
        currIndex += 2;
        return customer;
    }
}
