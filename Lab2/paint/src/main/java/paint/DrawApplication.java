package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class DrawApplication extends JFrame implements ActionListener {
	Container c;
	JMenuBar menubar;
	JMenu shape, color, edit;
	JMenuItem circle, rectangle, line;
	JMenuItem red, green, blue, yellow;
	JMenuItem undo, redo;
	int col = 0;
	Graphics g;

	HistoryList historyList = new HistoryList();

	DrawApplication() {
		c = getContentPane();

		menubar = new JMenuBar();
		shape = new JMenu("Shape");
		color = new JMenu("Color");
		edit = new JMenu("Edit");
		circle = new JMenuItem("Circle");
		rectangle = new JMenuItem("Rectangle");
		line = new JMenuItem("Line");
		red = new JMenuItem("Red");
		green = new JMenuItem("Green");
		blue = new JMenuItem("Blue");
		yellow = new JMenuItem("Yellow");
		undo = new JMenuItem("Undo");
		redo = new JMenuItem("Redo");
		
		shape.add(circle);
		shape.add(rectangle);
		shape.add(line);
		color.add(red);
		color.add(green);
		color.add(blue);
		color.add(yellow);
		edit.add(undo);
		edit.add(redo);
		menubar.add(shape);
		menubar.add(color);
		menubar.add(edit);

		setJMenuBar(menubar);

		c.setLayout(new FlowLayout(0));
		setSize(600, 600);
		setTitle("Draw Shape");
		setVisible(true);

		circle.addActionListener(this);
		rectangle.addActionListener(this);
		line.addActionListener(this);

		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		yellow.addActionListener(this);
		
		undo.addActionListener(this);
		redo.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {
		g = getGraphics();
		if (col == 1)
			g.setColor(Color.red);
		if (col == 2)
			g.setColor(Color.green);
		if (col == 3)
			g.setColor(Color.blue);
		if (col == 4)
			g.setColor(Color.yellow);

		if (ae.getSource() == red)
			col = 1;
		if (ae.getSource() == green)
			col = 2;
		if (ae.getSource() == blue)
			col = 3;
		if (ae.getSource() == yellow)
			col = 4;

		Random rand = new Random();
		int k= rand.nextInt(500);
		if (k < 150)k=150;
		int l= rand.nextInt(500);
		if (l < 150)l=150;
		int m= rand.nextInt(500);
		if (m < 150)m=150;
		int n= rand.nextInt(500);
		if (n < 150)n=150;
		if (ae.getSource() == circle) {
			Command c = new DrawCircle(g, k, l, m, n);
			c.execute();
			historyList.addCommand(c);
		}
		if (ae.getSource() == rectangle) {
			Command c = new DrawRectangle(g, k, l, m, n);
			c.execute();
			historyList.addCommand(c);
		}
		if (ae.getSource() == line) {
			Command c = new DrawLine(g, k, l, m, n);
			c.execute();
			historyList.addCommand(c);
		}
		
		if (ae.getSource() == undo) {
			System.out.println("perform undo");
			historyList.undo();
		}

		if (ae.getSource() == redo) {
			System.out.println("perform redo");
			historyList.redo();
		}

	}

	public static void main(String args[]) {
		new DrawApplication();
	}
}