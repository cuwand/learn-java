import java.util.concurrent.Phaser;

// A thread of execution that uses a phaser 
class ModifiedThread implements Runnable {
	Phaser phsr;
	String name;

	ModifiedThread(Phaser p, String n) {
		phsr = p;
		name = n;
		phsr.register();
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (!phsr.isTerminated()) {
			System.out.println("Thread " + name + " Beginning Phase " + phsr.getPhase());
			phsr.arriveAndAwaitAdvance();

			try {
				double randomDouble = Math.random();
				randomDouble = randomDouble * 2 + 1;
				int randomInt = (int) randomDouble;
				Thread.sleep(1000 * randomInt);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}