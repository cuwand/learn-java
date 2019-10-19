
public class Main {

	public static void printTitle(String title) {
		System.out.println("\n========== " + title + " ==========");
	}

	public static void sleepMe() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		printTitle("Creating and starting threads");
		ManualAnimation happy = new ManualAnimation("Mr. Happy");
		Thread myThread = new Thread(happy);
		myThread.setDaemon(true);
		myThread.start();
		sleepMe();
		myThread.stop();

		Animation adrianAnimation = new Animation("Adrian");
		sleepMe();
		adrianAnimation.myThread.stop();

		printTitle("A natural-born thread");
		NaturalBornAnimation nba = new NaturalBornAnimation("ASD");
		sleepMe();
		nba.stop();

		printTitle("Using an adapter");
		AnimationWithAdapter awa = new AnimationWithAdapter("NBA");
		awa.startAnimating();
		sleepMe();
		awa.stopAnimating();
		
		System.out.println("\nDone");
	}

}
