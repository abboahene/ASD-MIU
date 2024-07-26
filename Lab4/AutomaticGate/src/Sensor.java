public class Sensor {
    private GateController controller;

    public Sensor(GateController controller) {
        this.controller = controller;
    }

    public void sensorOpenSignal() {
        controller.sensorOpenSignal();
    }

    public void sensorClosedSignal() {
        controller.sensorClosedSignal();
    }
}
