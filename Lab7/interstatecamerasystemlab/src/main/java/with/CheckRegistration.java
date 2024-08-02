package with;

public class CheckRegistration extends Handler{

    public CheckRegistration(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handle(CameraRecord cameraRecord) {
        if (cameraRecord.getLicenseplate().equals("SA 9801")){
            System.out.println("send registration ticket");
        }
        nextHandler.handle(cameraRecord);
    }
}
