
// Java code illustrating initialValue() method 
import java.lang.*;

class NewThread extends Thread {
	private static ThreadLocal gfg = new ThreadLocal() {
		protected Object initialValue() {
			return new Integer(question--);
		}
	};

	private static int question = 15;

	NewThread(String name) {
		super(name);
		start();
	}

	public void run() {
		for (int i = 0; i < 5; i++)
			System.out.println(getName() + " -> " + gfg.get());
	}
}

public class Main {

	public static void main(String[] args) {

		NewThread t1 = new NewThread("quiz1");
		NewThread t2 = new NewThread("quiz2");
		NewThread t3 = new NewThread("quiz3");
		NewThread t4 = new NewThread("quiz4");
		NewThread t5 = new NewThread("quiz5");
	}
}