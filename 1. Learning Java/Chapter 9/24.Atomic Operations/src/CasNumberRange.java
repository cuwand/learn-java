import java.util.concurrent.atomic.AtomicReference;

public class CasNumberRange {
	// Immutable
	private static class IntPair {
		public IntPair(int lower, int upper) {
			this.lower = lower;
			this.upper = upper;
			// TODO Auto-generated constructor stub
		}

		final int lower; // Invariant: lower <= upper
		final int upper;
	}

	public int getLower() {
		return values.get().lower;
	}

	public int getUpper() {
		return values.get().upper;
	}

	private AtomicReference<IntPair> values;

	public CasNumberRange(int lower, int upper) {
		values = new AtomicReference<IntPair>(new IntPair(lower, upper));
	}

	public void setLower(int i) {
		while (true) {
			IntPair oldv = values.get();
			if (i > oldv.upper)
				throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
			IntPair newv = new IntPair(i, oldv.upper);
			if (values.compareAndSet(oldv, newv))
				return;
		}
	}
	// similarly for setUpper
}