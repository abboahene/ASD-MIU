package with;


public class CameraRecordReceiver {

	Handler rootHandler;
	
	public void receiveCameraRecord(CameraRecord cameraRecord) {

		System.out.println("receiving "+cameraRecord);
//		System.out.println(rootHandler);
		rootHandler.handle(cameraRecord);
	}

	public void setRootHandler(Handler rootHandler) {
		this.rootHandler = rootHandler;
	}
}
