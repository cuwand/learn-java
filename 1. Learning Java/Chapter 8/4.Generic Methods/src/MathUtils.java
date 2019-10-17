class MathUtils {
	public static <T extends Number> T max(T x, T y) {
		if (x.doubleValue() > y.doubleValue())
			return x;
		return y;
	}
}