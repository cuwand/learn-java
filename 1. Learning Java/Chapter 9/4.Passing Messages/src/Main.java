
public class Main {
	public static void main(String args[]) {
		/*
		 * Producer producer = new Producer(); new Thread(producer).start(); Consumer
		 * consumer = new Consumer(producer); new Thread(consumer).start();
		 */

		Producer producer = new Producer();
		new Thread(producer).start();

		NamedConsumer consumer = new NamedConsumer("One", producer);
		new Thread(consumer).start();
		consumer = new NamedConsumer("Two", producer);
		new Thread(consumer).start();
		
	}
}
