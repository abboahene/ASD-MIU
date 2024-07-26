package main.java.counter;

import java.util.ArrayList;
import java.util.List;

public class CounterChangedSubject {

    List<Observer> observerList;

    public CounterChangedSubject() {
        this.observerList = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }
    public void notifyObservers(int cnt){
        for(Observer observer: observerList){
            observer.update(cnt);
        }
    }
}
