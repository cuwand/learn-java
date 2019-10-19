import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinAdd extends RecursiveTask<Long> {

	private final long[] numbers;
	private final int start;
	private final int end;
	private final int level;
	public static final long threshold = 10_000;

	public ForkJoinAdd(long[] numbers) {
		this(numbers, 0, numbers.length, 0);
	}

	private ForkJoinAdd(long[] numbers, int start, int end, int level) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
		this.level = level;
	}

	private void printPrefix() {
		for (int i = 0; i < level; i++)
			System.out.print("-");
	}

	@Override
	protected Long compute() {

		int length = end - start;
		printPrefix();
		System.out.println("Level : " + level + " Length : " + length + " With Start : " + start + " End on : " + end);
		if (length <= threshold) {
			return add();
		}

		ForkJoinAdd firstTask = new ForkJoinAdd(numbers, start, start + length / 2, level + 1);
		firstTask.fork(); // start asynchronously

		ForkJoinAdd secondTask = new ForkJoinAdd(numbers, start + length / 2, end, level + 1);

		Long secondTaskResult = secondTask.compute();
		Long firstTaskResult = firstTask.join();

		return firstTaskResult + secondTaskResult;

	}

	private long add() {
		long result = 0;
		for (int i = start; i < end; i++) {
			result += numbers[i];
		}
		return result;
	}

	public static long startForkJoinSum(long n) {
		System.out.println("Starting To Sum 1 Until : " + n);
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinAdd(numbers);
		return new ForkJoinPool().invoke(task);
	}

}
