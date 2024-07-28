package customers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FilterIterator implements Iterator<Customer> {
    private final List<Customer> customerList;
    private int currIndex;

    public FilterIterator(List<Customer> customerList, Predicate<Customer> predicate) {
        this.customerList = customerList.stream()
                .filter(predicate)
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
