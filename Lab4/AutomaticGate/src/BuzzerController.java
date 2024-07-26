import java.beans.PropertyChangeListener;

class BuzzerController implements PropertyChangeListener {
    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        GateState newState = (GateState) evt.getNewValue();
        if (newState == GateState.OPENING || newState == GateState.CLOSING) {
            System.out.println("Buzzer: ON");
        } else {
            System.out.println("Buzzer: OFF");
        }
    }
}
