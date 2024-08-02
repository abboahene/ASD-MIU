package bank.service;

import java.lang.reflect.Proxy;
import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.proxy.LoggingProxy;
import bank.proxy.TimingProxy;


public class AccountService implements IAccountService {
	private final IAccountDAO loggingProxyAccountDAO;

	
	public AccountService(){
		AccountDAO accountDAO = new AccountDAO();
		ClassLoader accountDAOLoader = accountDAO.getClass().getClassLoader();

		IAccountDAO timingProxyAccountDAO = (IAccountDAO) Proxy.newProxyInstance(accountDAOLoader,
				new Class[]{IAccountDAO.class},
				new TimingProxy(accountDAO));

		loggingProxyAccountDAO = (IAccountDAO) Proxy.newProxyInstance(accountDAOLoader,
				new Class[]{IAccountDAO.class},
				new LoggingProxy(timingProxyAccountDAO));
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		loggingProxyAccountDAO.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = loggingProxyAccountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		loggingProxyAccountDAO.updateAccount(account);
	}

	public Account getAccount(long accountNumber) {
		Account account = loggingProxyAccountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return loggingProxyAccountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = loggingProxyAccountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		loggingProxyAccountDAO.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = loggingProxyAccountDAO.loadAccount(fromAccountNumber);
		Account toAccount = loggingProxyAccountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		loggingProxyAccountDAO.updateAccount(fromAccount);
		loggingProxyAccountDAO.updateAccount(toAccount);
	}
}
