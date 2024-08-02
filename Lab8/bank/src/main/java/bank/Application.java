package bank;

import java.lang.reflect.Proxy;
import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.proxy.TimingProxy;
import bank.service.AccountService;
import bank.service.IAccountService;



public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		ClassLoader accountServiceLoader = accountService.getClass().getClassLoader();
		IAccountService timingProxyAccountService = (IAccountService) Proxy.newProxyInstance(accountServiceLoader,
				new Class[]{IAccountService.class}, new TimingProxy(accountService));

		// create 2 accounts;
		timingProxyAccountService.createAccount(1263862, "Frank Brown");
		timingProxyAccountService.createAccount(4253892, "John Doe");
		//use account 1;
		timingProxyAccountService.deposit(1263862, 240);
		timingProxyAccountService.deposit(1263862, 529);
		timingProxyAccountService.withdraw(1263862, 230);
		//use account 2;
		timingProxyAccountService.deposit(4253892, 12450);
		timingProxyAccountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		
		Collection<Account> accountlist = timingProxyAccountService.getAllAccounts();
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


