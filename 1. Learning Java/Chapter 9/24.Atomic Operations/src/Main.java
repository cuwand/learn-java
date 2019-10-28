import java.util.concurrent.atomic.*;

public class Main {
	public static void main(String[] args) {
		AtomicBoolean bool = new AtomicBoolean(true);
		System.out.println(bool.get());

		System.out.println(bool.compareAndSet(true, false));
		System.out.println(bool.get());

		System.out.println(bool.compareAndSet(true, false));
		System.out.println(bool.get());

		// AtomicReference

		CasNumberRange x = new CasNumberRange(10, 100);

		System.out.println(x.getLower());
		System.out.println(x.getUpper());

		System.out.println("Done");
	}
}
