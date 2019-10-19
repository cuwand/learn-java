
public class AnimationWithAdapter {
	private Thread myThread;
	private String name;

	public AnimationWithAdapter(String name) {
		this.name = name;
	}

	public void startAnimating() {
		// do setup, load images, etc.
		this.myThread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					drawFrames();
				}
			}
		});
		this.myThread.setDaemon(true);

		this.myThread.start();
	}

	public void stopAnimating() {
		this.myThread.stop();
	}

	private void drawFrames() {
		System.out.println("AnimationWithAdapter Drawing Frames For " + this.name);
	}
}
