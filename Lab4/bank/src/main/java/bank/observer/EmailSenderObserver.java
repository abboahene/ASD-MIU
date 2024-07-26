package bank.observer;

import bank.domain.Account;
import bank.observer.accountCreated.AccountCreatedObserver;
import bank.service.IAccountService;

public class EmailSenderObserver extends AccountCreatedObserver {
    public EmailSenderObserver(IAccountService accountService) {
        super(accountService);
    }

    @Override
    public void update() {
        Account account = getAccountService().getChangedValue();
        sendEmail(account);
    }

    public void sendEmail(Account account) {
        System.out.println("Account created, send email: " + account.getAccountnumber());
    }
}
