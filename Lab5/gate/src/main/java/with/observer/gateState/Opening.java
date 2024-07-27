package with.observer.gateState;

import with.observer.GateController;

public class Opening extends GateState{

    public Opening(GateController gateController) {
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
        GateController gc = getGateController();
        GateState newStatus = new Open(gc);
        gc.setGateState(newStatus);
        gc.getSupport().firePropertyChange("open", this, newStatus);
    }

    @Override
    public void sensorCloseSignal() {
        System.out.println("This is not possible");
    }
}