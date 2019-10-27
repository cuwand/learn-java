import java.util.*;
import java.util.concurrent.*;
import java.net.*;
import java.io.IOException;

public class SiteTimer {
	CyclicBarrier barrier;
	List<Result> results = new ArrayList<Result>();

	private class Result implements Comparable<Result> {
		Long time;
		String site;

		Result(Long time, String site) {
			this.time = time;
			this.site = site;
		}

		public int compareTo(Result r) {
			return time.compareTo(r.time);
		}
	}

	static long timeConnect(String site) {
		long start = System.currentTimeMillis();
		try {
			new URL(site).openConnection().connect();
		} catch (IOException e) {
			return -1;
		}
		return System.currentTimeMillis() - start;
	}

	void showResults() {
		Collections.sort(results);
		for (Result result : results)
			System.out.printf("%-30.30s : %d\n", result.site, result.time);
		System.out.println("------------------");
	}

	public void start(String[] args) {
		Runnable showResultsAction = new Runnable() {
			public void run() {
				showResults();
				results.clear();
			}
		};
		barrier = new CyclicBarrier(args.length, showResultsAction);
		for (final String site : args)
			new Thread() {
				public void run() {
					while (true) {
						long time = timeConnect(site);
						results.add(new Result(time, site));
						try {
							// When all of the threads reach the await() method, the barrier action fires,
							// printing the results
							barrier.await();

							// the await() method returns an integer that indicates the order in which the
							// threads arrived at the barrier. This can be used to divide up work for the
							// next iteration of the threads. For example, if the threads’ jobs are not
							// identical, you could use the number to “elect” a leader thread or divide the
							// threads into two or more groups.
						} catch (BrokenBarrierException e) {
							// If any of the waiting threads is interrupted or times out (using the timed
							// wait version
							// of the await() method) the barrier is said to be “broken” and all of the
							// waiting threads
							// receive a BrokenBarrierException . In theory, the barrier can be “fixed” by
							// calling its
							// reset() method, but this is complicated because only one thread from the
							// group can
							// reset the barrier properly. A reset() while any other thread is waiting
							// causes the barrier
							// to be broken and the waiting threads to receive the exception again, so it is
							// probably
							// best to start over at this point.
							return;
						} catch (InterruptedException e) {
							return;
						}
					}
				}
			}.start();
	}
}