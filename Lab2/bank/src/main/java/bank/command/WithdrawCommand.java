package bank.command;

import bank.service.IAccountService;

public class WithdrawCommand extends Command {

    private long accountNumber;
    private double amount;

    public WithdrawCommand(IAccountService accountService, long accountNumber, double amount) {
        super(accountService);
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        getAccountService().withdraw(accountNumber, amount);
    }

    @Override
    public void unExecute() {
        getAccountService().deposit(accountNumber, amount);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

}
