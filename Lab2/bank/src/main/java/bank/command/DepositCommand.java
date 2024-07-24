package bank.command;

import bank.service.IAccountService;

public class DepositCommand extends Command {

    private long accountNumber;
    private double amount;
    public DepositCommand(IAccountService accountService, long accountNumber, double amount) {
        super(accountService);
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        getAccountService().deposit(accountNumber, amount);
    }

    @Override
    public void unExecute() {
        getAccountService().withdraw(accountNumber, amount);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

}
