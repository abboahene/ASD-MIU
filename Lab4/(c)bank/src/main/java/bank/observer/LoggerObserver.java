package bank.observer;

import bank.domain.Account;
import bank.observer.accountChanged.AccountChangedObserver;
import bank.service.IAccountService;

public class LoggerObserver extends AccountChangedObserver {
    public LoggerObserver(IAccountService accountService) {
        super(accountService);
    }

    @Override
    public void update() {
        Account account = getAccountService().getChangedValue();
        log(account);
    }

    public void log(Account account) {
        System.out.println("Account changed create log: " + account.getAccountnumber());
    }

}