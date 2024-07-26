package main.java.counter;

public class Counter extends CounterChangedSubject{
	
	private int count=0;
	
	public void increment(){
		count++;
    	notifyObservers(count);
	}
	
	public void decrement(){
		count--;
		notifyObservers(count);
	}



}
