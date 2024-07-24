package bank;

import java.util.Collection;

import bank.command.*;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;



public class Application {
	public static void main(String[] args) {
		CommandHistory commandHistory = new CommandHistory();

		IAccountService accountService = new AccountService();
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
//		accountService.deposit(1263862, 240);
//		accountService.deposit(1263862, 529);
		Command deposit1Acc1 = new DepositCommand(accountService, 1263862, 240);
		deposit1Acc1.execute();
		commandHistory.addCommand(deposit1Acc1);

		Command deposit2Acc1 = new DepositCommand(accountService, 1263862, 529);
		deposit2Acc1.execute();
		commandHistory.addCommand(deposit2Acc1);

//		accountService.withdraw(1263862, 230);
		Command withdrawAcc1 = new WithdrawCommand(accountService, 1263862, 230);
		withdrawAcc1.execute();
		commandHistory.addCommand(withdrawAcc1);

		// undo redo
		commandHistory.undo();
		commandHistory.redo();

		//use account 2;
		//accountService.deposit(4253892, 12450);
		Command deposit1Acc2 = new DepositCommand(accountService, 4253892, 12450);
		deposit1Acc2.execute();
		commandHistory.addCommand(deposit1Acc2);

//		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		Command transfer1Acc2 = new TransferFundsCommand(accountService, 4253892, 1263862, 100, "payment of invoice 10232");
		transfer1Acc2.execute();
		commandHistory.addCommand(transfer1Acc2);

		commandHistory.undo();
		commandHistory.redo(); 
		// show balances
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


