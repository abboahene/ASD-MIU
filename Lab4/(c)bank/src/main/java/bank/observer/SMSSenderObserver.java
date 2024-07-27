package bank.observer;

import bank.domain.Account;
import bank.observer.accountChanged.AccountChangedObserver;
import bank.service.IAccountService;

public class SMSSenderObserver extends AccountChangedObserver {
    public SMSSenderObserver(IAccountService accountService) {
        super(accountService);
    }

    @Override
    public void update() {
        Account account = getAccountService().getChangedValue();
        sendSMS(account);
    }

    public void sendSMS(Account account) {
        System.out.println("Account changed, send sms: " + account.getAccountnumber());
    }
}
