
public class Main {
	public static void main(String[] args) {
		MyWaitAndNotify mwan = new MyWaitAndNotify();
		Thread th = new Thread(new Runnable() {
			public void run() {
				mwan.waiterMethod();
			}
		});
		th.start();
		
		mwan.notifierMethod();
	}
}
