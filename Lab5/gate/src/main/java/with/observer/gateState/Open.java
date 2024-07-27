package with.observer.gateState;

import with.observer.GateController;

public class Open extends GateState{

    public Open(GateController gateController) {
        super(gateController);
    }

    @Override
    public void pressButton() {
        GateController gc = getGateController();
        GateState newStatus = new Closing(gc);
        gc.setGateState(newStatus);
        gc.getSupport().firePropertyChange("closing", this, newStatus);
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
