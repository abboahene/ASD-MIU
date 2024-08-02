package with;

public class CheckUnpaidTickets extends Handler{

    public CheckUnpaidTickets(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handle(CameraRecord cameraRecord) {
        if(cameraRecord.getLicenseplate().equals("KP 9978")){
            System.out.println("notify police, unpaid tickets");
        }
    }
}
