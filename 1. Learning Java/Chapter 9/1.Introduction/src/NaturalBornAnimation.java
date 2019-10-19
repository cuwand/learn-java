
public class NaturalBornAnimation extends Thread {
	boolean animate = true;
	String name;

	public NaturalBornAnimation(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (animate) {
			System.out.println("NaturalBornAnimation Drawing Frames For " + this.name);
		}
	}

}
