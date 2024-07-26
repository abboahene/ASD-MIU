import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Gate {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private GateState state = GateState.CLOSED;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void setState(GateState newState) {
        GateState oldState = this.state;
        this.state = newState;
        pcs.firePropertyChange("state", oldState, newState);
    }

    public GateState getState() {
        return state;
    }

    public void open() {
        setState(GateState.OPENING);
    }

    public void close() {
        setState(GateState.CLOSING);
    }

    public void stop() {
        setState(state == GateState.OPENING ? GateState.OPEN : GateState.CLOSED);
    }
}
