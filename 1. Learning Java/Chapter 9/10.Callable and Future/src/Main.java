import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(3); // 3 threads

		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() {
				int count = 0;
				while (true) {
					count++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (count > 10)
						break;
					System.out.println("Callable Called");
				}
				return 2 + 2;
			}
		};
		// alternative way
		// Callable<Integer> callable = Executors.callable(runnable, 2 + 2);

		System.out.println(callable);

		Future<Integer> result = executor.submit(callable);

		System.out.println(result);

		try {
			int val = result.get(5, TimeUnit.SECONDS);// blocks until ready

			System.out.println("Callable With Wait 5 Second : " + val);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {// timeout before the future task is complete
			e.printStackTrace();
		} finally {

			// shut down the executor manually
			executor.shutdown();

		}

		try {
			System.out.println("Waiting For next 7 Will not Executed Before 5 Second is finish or timeout");
			int val = result.get(7, TimeUnit.SECONDS);// blocks until ready
			System.out.println("It Wait From current condition (Total 12 Second) : " + val);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {// timeout before the future task is complete
			System.out.println(
			    "Waiting For 7 Second Still Timeout, So that mean its 7 second from start not from current condition");
		} finally {

			// shut down the executor manually
			executor.shutdown();

		}

	}

}
