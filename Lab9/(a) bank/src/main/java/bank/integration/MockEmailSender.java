package bank.integration;

public class MockEmailSender implements  IEmailSender{
    @Override
    public void send(String from, String to, String message){
        System.out.println("Sent mock email: " + message + " to" + to);
    }

}