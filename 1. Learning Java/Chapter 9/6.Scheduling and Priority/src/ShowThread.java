
class ShowThread extends Thread {
	String message;
	Integer count;

	ShowThread(String message, int priority) {
		this.message = message;
		this.count = 0;
		setPriority(priority);
	}

	public void run() {
		while (true) {
			count++;
			if (count % 100 == 0)
				System.out.println("\"" + message + "\" : " + count);
			// yield(); // this will make thread gives up resource
			// so Foo and Barr Will print alternating
		}
	}
}
