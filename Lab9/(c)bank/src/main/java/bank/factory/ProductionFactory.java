package bank.factory;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.integration.EmailSender;
import bank.integration.IEmailSender;

public class ProductionFactory implements EnvFactory{

    @Override
    public IAccountDAO getAccountDAO() {
        return new AccountDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return EmailSender.getInstance();
    }
}
