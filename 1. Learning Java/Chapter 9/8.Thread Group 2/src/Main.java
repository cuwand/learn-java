
import java.lang.*;

public class Main implements Runnable {

	public static void main(String[] args) {
		Main tg = new Main();
		tg.func();
	}

	public void func() {
		try {
			// create a new ThreadGroup and a child for that ThreadGroup.
			newThreadGroup pGroup = new newThreadGroup("ParentThreadGroup");
			newThreadGroup cGroup = new newThreadGroup(pGroup, "ChildThreadGroup");

			// create another thread
			Thread thr2 = new Thread(pGroup, this);
			System.out.println("Starting " + thr2.getName() + "...");
			// this will call run() method
			thr2.start();

			// create third thread
			Thread thr3 = new Thread(cGroup, this);
			System.out.println("Starting " + thr3.getName() + "...");
			// this will call run() method
			thr3.start();

			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}

			// interrupt the two threads
			thr2.interrupt();
			thr3.interrupt();

			// block until the other threads finish
			thr2.join();
			thr3.join();
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
	}

	public void run() {
		try {
			System.out.print(Thread.currentThread().getName());
			System.out.println(" executing...");

			while (true) {
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			Thread currThread = Thread.currentThread();
			System.out.print(currThread.getName());
			System.out.println(" interrupted:" + e.toString());

			// rethrow the exception
			throw new RuntimeException(e.getMessage());
		}
	}
}

class newThreadGroup extends ThreadGroup {

	newThreadGroup(String n) {
		super(n);
	}

	newThreadGroup(ThreadGroup parent, String n) {
		super(parent, n);
	}

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t + " has unhandled exception:" + e);
	}
}