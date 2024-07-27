package main.java.counter.counterState;

import main.java.counter.Counter;

public abstract class CounterState {

    protected Counter counter;

    public CounterState(Counter counter) {
        this.counter = counter;
    }



    public abstract void increment();
    public abstract void decrement();

}
