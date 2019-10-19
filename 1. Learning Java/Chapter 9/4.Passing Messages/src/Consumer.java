public class Consumer implements Runnable {
	Producer producer;

	Consumer(Producer producer) {
		this.producer = producer;
	}

	public void run() {
		while (true) {
			String message = producer.getMessage();
			System.out.println("Got message: " + message);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
	}
}