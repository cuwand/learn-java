
public class Main {
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("GroupA");

		new Task(group, "A").start();
		new Task(group, "B").start();
		new Task(group, "C").start();
		new Task(group, "D").start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		group.setDaemon(true);
		group.interrupt();

	}
}
