import java.util.Random;

public class Task extends Thread {
	Integer count;
	String name;

	public Task(String name, int priority) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.count = 0;
	}

	@Override
	public void run() {
		System.out.println("Starting " + name);
		// TODO Auto-generated method stub
		while (true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (new Random().nextInt(200) == 1) {
				break;
			}
			System.out.println(name + " : " + count++);
			yield();
		}
		System.out.println("Finishing " + name);
	}

}
