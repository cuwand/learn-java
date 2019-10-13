
//file: HelloJava4.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HelloComponent4 extends JComponent implements MouseMotionListener, ActionListener, Runnable {
	String theMessage;
	int messageX = 125, messageY = 95; // Coordinates of the message
	JButton theButton;
	int colorIndex; // Current index into someColors.
	static Color[] someColors = { Color.black, Color.red, Color.green, Color.blue, Color.magenta };
	boolean blinkState;

	public HelloComponent4(String message) {
		theMessage = message;
		theButton = new JButton("Change Color");
		setLayout(new FlowLayout());
		add(theButton);
		theButton.addActionListener(this);
		addMouseMotionListener(this);
		Thread t = new Thread(this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		// if blink state, print the color like the background
		g.setColor(blinkState ? getBackground() : currentColor());
		g.drawString(theMessage, messageX, messageY);
	}

	public void mouseDragged(MouseEvent e) {
		messageX = e.getX();
		messageY = e.getY();
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == theButton)
			changeColor();
	}

	// The synchronized modifier tells Java to acquire a lock for the object that
	// contains the method before executing that method. Only one method in the
	// object can have the lock at any given time, which means that only one
	// synchronized method in that object can be running at a time.
	synchronized private void changeColor() {
		if (++colorIndex == someColors.length)
			colorIndex = 0;
		setForeground(currentColor());
		repaint();
	}

	synchronized private Color currentColor() {
		return someColors[colorIndex];
	}

	public void run() {
		try {
			while (true) {
				blinkState = !blinkState; // Toggle blinkState.
				repaint(); // Show the change.
				Thread.sleep(500);
			}
		} catch (InterruptedException ie) {
		}
		System.out.println("This Will Never Printed");
	}
}