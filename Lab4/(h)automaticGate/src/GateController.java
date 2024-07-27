public class GateController {
    private final Gate gate;
    private final BuzzerController buzzer;

    public GateController(Gate gate, BuzzerController buzzer) {
        this.gate = gate;
        this.buzzer = buzzer;
    }

    public void pressButton() {
        switch (gate.getState()) {
            case OPEN:
                gate.close();
                break;
            case CLOSED:
                gate.open();
                break;
            case OPENING:
                gate.close();
                break;
            case CLOSING:
                gate.open();
                break;
        }
    }

    public void sensorOpenSignal() {
        gate.setState(GateState.OPEN);
    }

    public void sensorClosedSignal() {
        gate.setState(GateState.CLOSED);
    }
}
