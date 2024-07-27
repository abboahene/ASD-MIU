package main.java.counter.counterState;

import main.java.counter.Counter;

public class TwoDigitSate extends CounterState{

    public TwoDigitSate(Counter counter) {
        super(counter);
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount() + 2);
        if(counter.getCount() > 99){
            counter.setCounterState(new ThreeDigitState(counter));
        }
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount() - 2);
        if(counter.getCount() < 10){
            counter.setCounterState(new OneDigitState(counter));
        }
    }
}
