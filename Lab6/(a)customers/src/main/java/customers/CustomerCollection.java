package customers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerCollection {
	List<Customer> customers = new ArrayList<Customer>();
	
	public void add(Customer customer) {
		customers.add(customer);
	}

	public Iterator<Customer> getAgeIterator(){
		return new AgeIterator(customers);
	}
	
	public void print() {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

}
