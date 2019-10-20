import java.util.concurrent.locks.*;

public class MyLock {
	Lock lock = new ReentrantLock();

	public MyLock() {

	}

	public void manualLock1() {
		System.out.println("Manual Locking 1 is Running");
		// method or block
		lock.lock();
		try {
			System.out.println("Manual Locking 1 is Gaining Lock and Processing");
			Thread.sleep(1000);
			// body of method or block ...
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();

			System.out.println("Manual Locking 1 is Gives Up Lock");
		}

		System.out.println("Manual Locking 1 is Ended");
	}

	public void manualLock2() {
		System.out.println("Manual Locking 2 is Running");
		// method or block
		lock.lock();
		try {
			System.out.println("Manual Locking 2 is Gaining Lock and Processing");
			Thread.sleep(1000);
			// body of method or block ...
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("Manual Locking 2 is Gives Up Lock");
		}

		System.out.println("Manual Locking 2 is Ended");
	}
}
