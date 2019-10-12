import java.awt.*;
import javax.swing.JComponent;

public class HelloComponent extends JComponent {
  public void paintComponent( Graphics g ) {
    g.drawString( "Hello, Java Component!", 125, 95 );
  }
}
