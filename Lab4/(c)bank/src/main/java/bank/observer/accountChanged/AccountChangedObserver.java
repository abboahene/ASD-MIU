package bank.observer.accountChanged;

import bank.service.IAccountService;

public abstract class AccountChangedObserver {
    private IAccountService accountService;

    public AccountChangedObserver(IAccountService accountService) {
        this.accountService = accountService;
    }

    public abstract void update();

    public IAccountService getAccountService() {
        return accountService;
    }

}
