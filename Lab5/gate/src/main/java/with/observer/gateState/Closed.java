package with.observer.gateState;

import with.observer.GateController;

public class Closed extends GateState{

    public Closed(GateController gateController) {
        super(gateController);
    }

    @Override
    public void pressButton() {
        GateController gc = getGateController();
        GateState newStatus = new Opening(gc);
        gc.setGateState(newStatus);
        gc.getSupport().firePropertyChange("opening", this, newStatus);
    }

    @Override
    public void sensorOpenSignal() {
        System.out.println("This is not possible");
    }

    @Override
    public void sensorCloseSignal() {
        System.out.println("This is not possible");
    }
}
