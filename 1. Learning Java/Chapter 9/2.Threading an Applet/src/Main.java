import java.awt.FlowLayout;

import javax.swing.JFrame;
public class Main {
	public static void main(String[] args) {
		new Clock();
		
		JFrame frame = new JFrame("Clock");
		frame.add(new Clock());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		System.out.println("Done");
	}
}
