package bank.integration;

public interface IEmailSender {
    public void send(String from, String to, String message);
}
