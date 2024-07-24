package paint;

import java.awt.*;

public class DrawRectangle extends Command {
    int k;
    int l;
    int m;
    int n;

    public DrawRectangle(Graphics g, int k, int l, int m, int n) {
        super(g);
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
    }

    @Override
    public void execute() {
        getG().fillRect(k, l, m, n);
    }
}
