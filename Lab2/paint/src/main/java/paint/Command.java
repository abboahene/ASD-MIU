package paint;

import java.awt.*;

public abstract class Command {

    private Graphics g;

    public Command(Graphics g) {
        this.g = g;
    }

    public Graphics getG() {
        return g;
    }

    public abstract void execute();
}
