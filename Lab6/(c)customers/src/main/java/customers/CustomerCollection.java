package customers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CustomerCollection {
	List<Customer> customers = new ArrayList<Customer>();
	
	public void add(Customer customer) {
		customers.add(customer);
	}

	public Iterator<Customer> getAgeIterator(){
		return new AgeIterator(customers);
	}
	public Iterator<Customer> getfilterIterator(Predicate<Customer> predicate){
		return new FilterIterator(customers, predicate);
	}

	public Iterator<Customer> getStep2Iterator(){
		return new Step2Iterator(customers);
	}

	public void print() {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

}
