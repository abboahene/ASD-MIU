package with.observer.gateState;

import with.observer.GateController;

public abstract class GateState {

    private GateController gateController;

    GateState(GateController gateController){
        this.gateController = gateController;
    }

    public abstract void pressButton();
    public abstract void sensorOpenSignal();
    public abstract void sensorCloseSignal();

    public GateController getGateController(){
        return gateController;
    }
}
