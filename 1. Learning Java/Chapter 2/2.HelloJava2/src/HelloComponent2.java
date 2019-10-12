import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

class HelloComponent2 extends JComponent implements MouseMotionListener {
  String theMessage;
  int messageX = 125, messageY = 95; // Coordinates of the message
  public HelloComponent2( String message ) {
    theMessage = message;
    addMouseMotionListener(this);
  }
  public void paintComponent( Graphics g ) {
    g.drawString( theMessage, messageX, messageY );
  }
  public void mouseDragged(MouseEvent e) {
    // Save the mouse coordinates and paint the message.
    this.messageX = e.getX();
    this.messageY = e.getY();
    repaint();
  }
  public void mouseMoved(MouseEvent e) { 
	this.messageX = e.getX();
	this.messageY = e.getY();
	paintComponent(this.getGraphics());
  }
}