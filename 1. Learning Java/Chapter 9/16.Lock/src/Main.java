
public class Main {
	public static void main(String[] args) {
		MyLock ml = new MyLock();

		new Thread() {
			public void run() {
				ml.manualLock1();
			}
		}.start();

		new Thread() {
			public void run() {
				ml.manualLock2();
			}
		}.start();

		System.out.println("Done");
	}
}
