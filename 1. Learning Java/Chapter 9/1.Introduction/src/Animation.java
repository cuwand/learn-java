
public class Animation implements Runnable {
	boolean animate = true;
	Thread myThread;
	String name;

	public Animation(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		myThread = new Thread(this);
		myThread.setDaemon(true);
		myThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (animate) {
			System.out.println("Animation Drawing Frames For " + this.name);
		}
	}
}
