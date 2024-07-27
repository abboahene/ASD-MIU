package with.observer.gateState;

import with.observer.GateController;

public class Paused extends GateState{

    private GateState prevState;
    public Paused(GateController gateController, GateState prevState) {
        super(gateController);
        this.prevState = prevState;
    }

    @Override
    public void pressButton() {
        GateController gc = getGateController();
        gc.setGateState(prevState);
        if(prevState.getClass() == Opening.class){
            gc.getSupport().firePropertyChange("opening", this, prevState);
        }else if(prevState.getClass() == Closing.class){
            gc.getSupport().firePropertyChange("closing", this, prevState);
        }
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