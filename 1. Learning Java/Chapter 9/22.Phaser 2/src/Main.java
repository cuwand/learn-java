import java.util.concurrent.Phaser;

public class Main {
	public static void main(String[] args) {
		Phaser phaser = new Phaser();
		int currentPhase;

		Thread t = new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println("");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
				}
			}
		};
		t.start();

		System.out.println("Starting");

		new MyThread(phaser, "A");
		new MyThread(phaser, "B");
		new MyThread(phaser, "C");

		// Wait for all threads to complete phase one.
		currentPhase = phaser.getPhase();

		// rebutan sama yang dalem My Thread
		System.out.println("Wait And Advance From Main");
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase " + currentPhase + " Complete");
		System.out.println("Phase Zero Ended");

		// Wait for all threads to complete phase two.
		currentPhase = phaser.getPhase();
		System.out.println("Wait And Advance From Main");
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase " + currentPhase + " Complete");
		System.out.println("Phase One Ended");

		currentPhase = phaser.getPhase();
		System.out.println("Wait And Advance From Main");
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase " + currentPhase + " Complete");
		System.out.println("Phase Two Ended");

		// Deregister the main thread.
		phaser.arriveAndDeregister();
		if (phaser.isTerminated()) {
			System.out.println("Phaser is terminated");
			t.interrupt();
		}

		System.out.println("Done.");
	}
}