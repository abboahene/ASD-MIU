package with.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BuzzerController implements PropertyChangeListener {
    public void start(){
        System.out.println("The buzzer is buzzing");
    }

    public void stop() {
        System.out.println("The buzzer has stopped");
    }

    public void paused() {
        System.out.println("The buzzer has paused");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("opening") || evt.getPropertyName().equals("closing")){
            start();
        }
        else if (evt.getPropertyName().equals("open") || evt.getPropertyName().equals("closed")){
            stop();
        }
        else if (evt.getPropertyName().equals("paused")){
            paused();
        }
    }
}
