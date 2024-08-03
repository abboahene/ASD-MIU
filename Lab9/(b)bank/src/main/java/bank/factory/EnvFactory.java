package bank.factory;

import bank.dao.IAccountDAO;
import bank.integration.IEmailSender;

public interface EnvFactory {

    IAccountDAO getAccountDAO();
    IEmailSender getEmailSender();
}
