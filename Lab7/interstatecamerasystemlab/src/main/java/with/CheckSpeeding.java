package with;

public class CheckSpeeding extends Handler{

    public CheckSpeeding(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handle(CameraRecord cameraRecord) {
        if (cameraRecord.getSpeed() > 69){
            System.out.println("send speeding ticket");
        }
        nextHandler.handle(cameraRecord);
    }
}