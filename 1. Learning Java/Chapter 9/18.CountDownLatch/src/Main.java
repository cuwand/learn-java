import java.util.concurrent.CountDownLatch;

public class Main {
	public static void main(String[] args) {
		int count = 10;
		CountDownLatch latch = new CountDownLatch(count); // count from 2
		// thread 1

		new Thread() {
			public void run() {
				try {
					System.out.println("Waiting Latch To be released");
					latch.await();
					System.out.println("Latch Released");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // blocks thread 1

			}
		}.start();

		new Thread() {
			public void run() {

				for (int i = 0; i < count; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					latch.countDown();
					System.out.println("Wait " + (count - i) + " Latch More");
				}
			}
		}.start();

		System.out.println("Done");
	}
}
