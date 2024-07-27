package main.java.counter;

import main.java.counter.counterState.CounterState;
import main.java.counter.counterState.OneDigitState;

public class Counter extends CounterChangedSubject{

	CounterState counterState = new OneDigitState(this);
	private int count=0;
	
	public void increment(){
		counterState.increment();
    	notifyObservers(count);
	}
	
	public void decrement(){
		counterState.decrement();
		notifyObservers(count);
	}

	public CounterState getCounterState() {
		return counterState;
	}

	public void setCounterState(CounterState counterState) {
		this.counterState = counterState;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
