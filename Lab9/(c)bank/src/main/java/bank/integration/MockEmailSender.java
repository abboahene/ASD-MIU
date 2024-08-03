package bank.integration;

public class MockEmailSender implements  IEmailSender{
    private static MockEmailSender mailer;
    private MockEmailSender() {
        // Prevent form the reflection api.
        if (mailer != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static MockEmailSender getInstance(){
        if(mailer == null){
            synchronized (EmailSender.class) {
                if(mailer == null){
                    mailer = new MockEmailSender();
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