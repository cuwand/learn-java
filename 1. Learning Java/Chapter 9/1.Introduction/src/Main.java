
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManualAnimation happy = new ManualAnimation("Mr. Happy");
		Thread myThread = new Thread( happy );
		myThread.start();
		try {
			myThread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myThread.stop();
		
		Animation adrianAnimation = new Animation("Adrian");
		try {
			adrianAnimation.myThread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adrianAnimation.myThread.stop();
	}

}
