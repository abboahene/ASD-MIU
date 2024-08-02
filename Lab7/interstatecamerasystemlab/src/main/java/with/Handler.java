package with;

public abstract class Handler {

    protected Handler nextHandler;

    Handler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }
    abstract void handle(CameraRecord cameraRecord);
}
