import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Executor executor = Executors.newFixedThreadPool(3);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
		completionService.submit(new MyCallable(1));

		// poll for result
		Future<Integer> result = completionService.poll();
		while (true) {
			if (result == null) {
				continue;
			}
			try {
				System.out.println("Result it not null");
				System.out.println(result.get());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}

		Future<Integer> result1;
		try {
			result1 = completionService.take();
			System.out.println("Result with take() >> " + result1.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Done");
	}

}
