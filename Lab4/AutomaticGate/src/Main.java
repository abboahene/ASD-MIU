public class Main {
    public static void main(String[] args) {
        Gate gate = new Gate();
        BuzzerController buzzer = new BuzzerController();
        LightController light = new LightController();

        gate.addPropertyChangeListener(buzzer);
        gate.addPropertyChangeListener(light);

        GateController controller = new GateController(gate, buzzer, light);
        Remote remote = new Remote(controller);
        Sensor sensor = new Sensor(controller);

        System.out.println("Initial state: " + gate.getState());

        remote.pressButton(); // Opens the gate
        sensor.sensorOpenSignal(); // Gate fully opened
        remote.pressButton(); // Starts closing the gate
        remote.pressButton(); // Reverses, starts opening the gate
        sensor.sensorOpenSignal(); // Gate fully opened
        remote.pressButton(); // Starts closing the gate
        sensor.sensorClosedSignal(); // Gate fully closed
    }
}
