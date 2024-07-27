package main.java.counter.counterState;

import main.java.counter.Counter;

public class OneDigitState extends CounterState{
    public OneDigitState(Counter counter) {
        super(counter);
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount() + 1);
        if(counter.getCount() > 9){
            counter.setCounterState(new TwoDigitSate(counter));
        }
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount() - 1);

    }
}
