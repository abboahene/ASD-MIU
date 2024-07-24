package bank.command;

import bank.service.AccountService;
import bank.service.IAccountService;

public abstract class Command {

    private IAccountService accountService;

    public Command(IAccountService accountService) {
        this.accountService = accountService;
    }

    public IAccountService getAccountService() {
        return accountService;
    }

    public abstract void execute();
    public abstract void unExecute();
}
