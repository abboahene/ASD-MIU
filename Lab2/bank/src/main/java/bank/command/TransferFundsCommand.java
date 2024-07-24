package bank.command;

import bank.service.IAccountService;

public class TransferFundsCommand extends Command {

    long fromAccountNumber;
    long toAccountNumber;
    double amount;
    String description;

    public TransferFundsCommand(IAccountService accountService, long fromAccountNumber, long toAccountNumber, double amount, String description) {
        super(accountService);
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute() {
        getAccountService().transferFunds(fromAccountNumber, toAccountNumber, amount, description);
    }

    @Override
    public void unExecute() {
        getAccountService().transferFunds(toAccountNumber, fromAccountNumber , amount, description);;
    }

    public long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public long getToAccountNumber() {
        return toAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
