public class ExceptionTester<T extends Throwable> {
	public void test(T exception) throws T {
		// throw type is generic param
		throw exception;
	}

}