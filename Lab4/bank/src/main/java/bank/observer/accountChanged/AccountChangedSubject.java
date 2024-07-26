package bank.observer.accountChanged;

import java.util.ArrayList;
import java.util.List;

public class AccountChangedSubject {

    List<AccountChangedObserver> observerList;

    public AccountChangedSubject() {
        this.observerList = new ArrayList<>();
    }

    public void addObserver(AccountChangedObserver observer){
        observerList.add(observer);
    }
    public void removeObserver(AccountChangedObserver observer){
        observerList.remove(observer);
    }
    public void notifyObservers(){
        for(AccountChangedObserver observer: observerList){
            observer.update();
        }
    }
}
