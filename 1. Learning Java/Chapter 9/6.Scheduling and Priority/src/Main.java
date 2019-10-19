
public class Main {

	public static void main(String[] args) {

		//Top priority is 10, lowest priority is 1
		Thread foo = new ShowThread("Foo", 10);
		Thread bar = new ShowThread("Bar", 10);

		// TODO Auto-generated method stub
		Thread[] threads = new Thread[64]; // max threads to show
		int num = Thread.enumerate(threads);
		System.out.println("Count Threads : " + num);
		for (int i = 0; i < num; i++)
			System.out.println(threads[i] + ":" + threads[i].getState());

		foo.start();
		bar.start();
		System.out.println("Done");
	}

}
