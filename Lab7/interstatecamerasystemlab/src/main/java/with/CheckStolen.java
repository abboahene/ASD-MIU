package with;

public class CheckStolen extends Handler{

    public CheckStolen(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handle(CameraRecord cameraRecord) {
        if(cameraRecord.getLicenseplate().equals("KL 0001")){
            System.out.println("notify police, stolen car");
            return;
        }
        nextHandler.handle(cameraRecord);
    }
}