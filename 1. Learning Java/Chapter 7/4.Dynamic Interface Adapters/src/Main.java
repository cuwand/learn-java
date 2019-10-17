
public class Main {
	public static void main(String[] args) {
		Task task = (Task) ProxyFactory.newInstance(new TaskImpl());
		task.setData("Test");
		task.hurray("OK", 12);
		System.out.println(task.getCalData(5));
	}
}
