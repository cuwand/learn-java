public class Main {
	public static void main(String[] args) throws InterruptedException {
		SharedFiFoQueue sharedQueue = new SharedFiFoQueue(10);

		// Create a producer and a consumer.
		Thread producer = new Producer(sharedQueue, "input.txt");
		Thread consumer = new Consumer(sharedQueue);

		// Start both threads.
		producer.start();
		consumer.start();

		// Wait for both threads to terminate.
		producer.join();
		consumer.join();
	}
}
