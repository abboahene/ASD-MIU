package bank.observer.accountCreated;

import bank.observer.accountChanged.AccountChangedObserver;

import java.util.ArrayList;
import java.util.List;

public class AccountCreatedSubject {

    List<AccountCreatedObserver> observerList;

    public AccountCreatedSubject() {
        this.observerList = new ArrayList<>();
    }

    public void addObserver(AccountCreatedObserver observer){
        observerList.add(observer);
    }
    public void removeObserver(AccountChangedObserver observer){
        observerList.remove(observer);
    }
    public void notifyObservers(){
        for(AccountCreatedObserver observer: observerList){
            observer.update();
        }
    }
}
