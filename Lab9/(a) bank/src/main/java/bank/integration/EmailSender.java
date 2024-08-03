package bank.integration;

public class EmailSender implements IEmailSender {

    @Override
    public void send(String from, String to, String message){
        System.out.println("Sent email: " + message + " to" + to);
    }

}
