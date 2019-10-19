import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;

public class Clock extends UpdateApplet {
	public Clock() {
		this.start();
	}

	public void paint(java.awt.Graphics g) {
		System.out.println("Paint Called");
		g.setFont(new Font("default", Font.BOLD, 16));
		g.drawString("Clock", 130, 50);

		g.setFont(new Font("default", Font.PLAIN, 12));
		g.drawString(new java.util.Date().toString(), 80, 125);
	}
}