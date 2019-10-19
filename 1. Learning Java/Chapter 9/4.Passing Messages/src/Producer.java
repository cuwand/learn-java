import java.util.*;

public class Producer implements Runnable {
	static final int MAXQUEUE = 5;
	private List messages = new ArrayList();

	public void run() {
		while (true) {
			putMessage();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
// called by Producer internally

	private synchronized void putMessage() {
		while (messages.size() >= MAXQUEUE)
			try {
				System.out.println("Wait on Put, Message size > " + MAXQUEUE);
				wait();
			} catch (InterruptedException e) {
			}

		messages.add(new java.util.Date().toString());


		System.out.println("Notify on Put Message, Successfully put messages");
		notify();
	}

// called by Consumer externally
	public synchronized String getMessage() {
		while (messages.size() == 0)
			try {
				System.out.println("Notify on Get Message, No Message");
				notify();
				System.out.println("Wait on Get Message, No Message");
				wait();
			} catch (InterruptedException e) {
			}
		String message = (String) messages.remove(0);

		System.out.println("Notify on Successfully Get Message");
		notify();
		return message;
	}
}