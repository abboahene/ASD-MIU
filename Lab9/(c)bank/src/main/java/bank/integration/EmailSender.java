package bank.integration;

public class EmailSender implements IEmailSender {

    private static EmailSender mailer;
    private EmailSender() {
        // Prevent form the reflection api.
        if (mailer != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static EmailSender getInstance(){
        if(mailer == null){
            synchronized (EmailSender.class) {
                if(mailer == null){
                    mailer = new EmailSender();
                }
            }
        }
        return mailer;
    }
    @Override
    public void send(String from, String to, String message){
        System.out.println("Sent email: " + message + " to" + to);
    }
}
