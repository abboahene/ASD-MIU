package with.observer.gateState;

import with.observer.GateController;

public class Closing extends GateState{

    public Closing(GateController gateController) {
        super(gateController);
    }

    @Override
    public void pressButton() {
        GateController gc = getGateController();
        GateState newStatus = new Paused(gc, this);
        gc.setGateState(newStatus);
        gc.getSupport().firePropertyChange("paused", this, newStatus);
    }

    @Override
    public void sensorOpenSignal() {
        System.out.println("This is not possible");
    }

    @Override
    public void sensorCloseSignal() {
        GateController gc = getGateController();
        GateState newStatus = new Closed(gc);
        gc.setGateState(newStatus);
        gc.getSupport().firePropertyChange("closed", this, newStatus);
    }
}
