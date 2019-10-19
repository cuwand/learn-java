import java.util.concurrent.Callable;

class MyCallable implements Callable<Integer> {
	int customNumber;

	public MyCallable(int customNumber) {
		System.out.println("My Callable Created....");
		this.customNumber = customNumber;
	}

	public Integer call() {
		System.out.println("Calculating Number");
		return this.customNumber + 2;
	}
}