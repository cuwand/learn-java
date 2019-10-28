import java.util.concurrent.Exchanger;

// A thread that uses a string 
class UseString implements Runnable {

	Exchanger<String> ex;
	String str;

	UseString(Exchanger<String> ex) {
		this.ex = ex;

		new Thread(this).start();
	}

	public void run() {
		try {
			for (int i = 0; i < 3; i++) {
				if (i == 2) {
					// Thread sleeps for 500 milliseconds
					// causing timeout
					Thread.sleep(500);
					continue;
				}

				// Exchange an empty buffer for a full one
				str = ex.exchange(new String());
				System.out.println("Got: " + str);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
