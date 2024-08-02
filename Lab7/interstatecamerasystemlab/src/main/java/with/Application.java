package with;


public class Application {

	public static void main(String[] args) {
		Handler checkUnpaidTickets = new CheckUnpaidTickets(null);
		Handler checkSpeeding = new CheckSpeeding(checkUnpaidTickets);
		Handler checkRegistration = new CheckRegistration(checkSpeeding);
		Handler checkStolen = new CheckStolen(checkRegistration);

		CameraRecordReceiver cameraRecordReceiver = new CameraRecordReceiver();
		cameraRecordReceiver.setRootHandler(checkStolen);
		Camera camera = new Camera(cameraRecordReceiver);
		camera.generateCameraRecords();

	}

}
