package bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.observer.accountChanged.AccountChangedSubject;
import bank.observer.accountCreated.AccountCreatedSubject;


public class AccountService extends AccountChangedSubject implements IAccountService {
	private IAccountDAO accountDAO;

	private Account changedAccount;
	private AccountCreatedSubject accountCreatedSubject;

	public AccountService() {
		this.accountDAO = new AccountDAO();
		this.accountCreatedSubject = new AccountCreatedSubject();
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		changedAccount = account;
		accountCreatedSubject.notifyObservers();
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		changedAccount = account;
		notifyObservers();
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		changedAccount = account;
		notifyObservers();
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		changedAccount = fromAccount;
		notifyObservers();
	}

	public Account getChangedValue(){
		return changedAccount;
	}

	public AccountCreatedSubject getAccountCreatedSubject() {
		return accountCreatedSubject;
	}
}
