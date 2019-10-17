
public class Main {
	public static void main(String[] args) {
		String myString = "Foo!";
		Class stringClass = myString.getClass();
		System.out.printf("stringClass >> %s\n", stringClass);
		stringClass = String.class;
		System.out.printf("stringClass >> %s\n", stringClass);

		String s = "Boofa!";
		stringClass = s.getClass();
		System.out.printf("stringClass >> %s\n", stringClass.getName());

		try {
			String s2 = (String) stringClass.newInstance(); // calling default constructor
			System.out.printf("s2 >%s\n", s2);
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		}

		Class<String> strClass = String.class;
		try {
			String s2 = strClass.newInstance(); // no cast necessary
			System.out.printf("s2 >%s\n", s2);
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		}

		try {
			Class sneakersClass = Class.forName("Sneakers");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found " + e.getMessage());
		}
		
		MyApplication app = new MyApplication();
		app.printData();
	}
}
