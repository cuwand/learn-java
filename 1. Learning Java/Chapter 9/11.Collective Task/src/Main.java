import java.util.*;
import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Callable<Integer>> taskList = new ArrayList<Callable<Integer>>();

		taskList.add(new MyCallable(1));
		taskList.add(new MyCallable(2));
		taskList.add(new MyCallable(3));
		ExecutorService execService = Executors.newFixedThreadPool(3);
		try {
			System.out.println("Invoking Result List");
			List<Future<Integer>> resultList = execService.invokeAll(taskList);
			System.out.println("Trying to Get Result Lists");
			for (Future<Integer> res : resultList) {
				System.out.println(res.get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
