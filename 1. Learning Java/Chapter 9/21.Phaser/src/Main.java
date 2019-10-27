
public class Main {
	public static void main(String[] args) {
		MyPhaser phsr = new MyPhaser(1, 4);
		System.out.println("Starting");

		new ModifiedThread(phsr, "A");
		new ModifiedThread(phsr, "B");
		new ModifiedThread(phsr, "C");

		while (!phsr.isTerminated()) {
			phsr.arriveAndAwaitAdvance();
		}
		System.out.println("The phaser is terminated\n");
	}
}
