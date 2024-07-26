import java.beans.PropertyChangeListener;

public class LightController implements PropertyChangeListener {
    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        GateState newState = (GateState) evt.getNewValue();
        switch (newState) {
            case CLOSING:
                System.out.println("Light: Flashing RED");
                break;
            case OPENING:
                System.out.println("Light: Flashing ORANGE");
                break;
            default:
                System.out.println("Light: OFF");
        }
    }
}
