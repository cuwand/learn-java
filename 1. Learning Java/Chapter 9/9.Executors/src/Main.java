import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(3); // 3 threads

		List<Runnable> runnables = new ArrayList<Runnable>();

		runnables.add(new Task("Foo", 10));
		runnables.add(new Task("Bar", 10));
		runnables.add(new Task("Adr", 1));
		runnables.add(new Task("Eka", 1)); // this will never executes before 1 of them ended

		// we’ve been able to throttle the concurrency of our task list and avoid the
		// details of constructing any threads ourselves.
		for (Runnable task : runnables)
			executor.execute(task);
	}
}
