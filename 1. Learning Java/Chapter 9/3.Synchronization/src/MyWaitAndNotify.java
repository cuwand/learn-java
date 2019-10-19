
public class MyWaitAndNotify {
	synchronized void waiterMethod() {
		// do some stuff
		System.out.println("Waiter Method Executed");
		try {
			// now wait for notifier to do something
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// continue where we left off
		System.out.println("Waiter Method Ended");
	}

	synchronized void notifierMethod() {
		// do some stuff
		System.out.println("Notifier Method Executed");
		// wait will run after this method return;
		notify(); // notify waiter that we've done it
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Notifier Method Ended");
		// continue doing stuff
	}

	synchronized void relatedMethod() {
		// do some related stuff
	}
}
