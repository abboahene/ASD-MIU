package main.java.counter.counterState;

import main.java.counter.Counter;

public class ThreeDigitState extends CounterState{

    public ThreeDigitState(Counter counter) {
        super(counter);
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount() + 3);
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount() - 3);
        if(counter.getCount() < 100){
            counter.setCounterState(new TwoDigitSate(counter));
        }
    }
}