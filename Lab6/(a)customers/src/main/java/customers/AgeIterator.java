package customers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AgeIterator implements Iterator<Customer> {
    private final List<Customer> customerList;
    private int currIndex;

    public AgeIterator(List<Customer> customerList) {
        this.customerList = customerList.stream()
                .sorted(Comparator.comparingInt(Customer::getAge))
                .toList();
        currIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currIndex < customerList.size();
    }

    @Override
    public Customer next() {
        if(!hasNext()) return null;
        return customerList.get(currIndex++);
    }
}
