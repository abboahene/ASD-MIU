package with.observer;

import with.observer.gateState.Closed;
import with.observer.gateState.GateState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GateController {
//    private enum GateState {
//        OPEN,
//        CLOSED,
//        OPENING,
//        CLOSING;
//    }
    private GateState gateState = new Closed(this);

    private PropertyChangeSupport support;

    public GateController() {
        support = new PropertyChangeSupport(this);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void pressButton(){
        gateState.pressButton();
    }

    public void sensorOpenSignal(){
       gateState.sensorOpenSignal();
    }

    public void sensorCloseSignal(){
       gateState.sensorCloseSignal();
    }

    public PropertyChangeSupport getSupport() {
        return support;
    }

    public GateState getGateState() {
        return gateState;
    }
    public void setGateState(GateState newGateState) {
        gateState = newGateState;
    }
}
