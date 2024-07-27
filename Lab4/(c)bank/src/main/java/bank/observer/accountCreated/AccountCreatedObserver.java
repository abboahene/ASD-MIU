package bank.observer.accountCreated;

import bank.service.IAccountService;

public abstract class AccountCreatedObserver {
    IAccountService accountService;

    public AccountCreatedObserver(IAccountService accountService) {
        this.accountService = accountService;
    }

    public abstract void update();

    public IAccountService getAccountService() {
        return accountService;
    }
}
