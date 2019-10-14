import java.util.*;

public class Main {
	private static final int MINISCULE = 1;
	private static final int TEENYWEENIE = 2;
	private static final int SMALL = 3;
	private static final int MEDIUM = 4;
	private static final int LARGE = 5;
	private static final int EXTRALARGE = 6;

	enum Size {
		Small, Medium, Large
	};

	static String mainName;

	public static void setName(String _name) {
		mainName = _name;
	}

	public static String getName() {
		return mainName;
	}

	public static String printTitle(String title) {
		return "========== " + title + " ==========";
	}

	public static String printSubTitle(String title) {
		return "--> " + title;
	}

	public static int setUpDog(String name) {
		int size = 100;
		setName(name);
		return size;
	}

	public static void unreachableStatement() {
		System.out.println(printSubTitle("Unreachable statements"));
		if (1 < 2)
			return;
		System.out.println("This Will not printed");
	}

	public static void main(String[] args) {
		System.out.println(printTitle("Statements and Expressions"));
		// TODO Auto-generated method stub
		{
			int size = 5;
			if (size > 10)
				System.out.println("Size > 10 ");
			for (int x = 0; x < size; x++) {
				System.out.println("Size : " + String.valueOf(x));
			}
		}

		System.out.println(printSubTitle("Statements"));
		{
			int size = 5;
			setName("Max");
			System.out.println(getName());
			System.out.println(size);
		}

		int size = setUpDog("Doggy");
		System.out.println(getName());
		System.out.println(size);

		{
			int i = 5;
		}
		// i = 6; Compile-time error, no such variable i

		System.out.println(printSubTitle("if/else conditionals"));
		boolean likeMango = true;

		// Exactly 1 statement inside if
		if (likeMango)
			System.out.println(getName() + " like Mango");
		else
			System.out.println(getName() + " doesn't like Mango");

		likeMango = !likeMango;

		// More than 1 statement inside if
		if (likeMango) {
			likeMango = false;
			System.out.println(getName() + " like Mango");
		} else {
			setName("Hidden");
			System.out.println(getName() + " doesn't like Mango");
		}

		System.out.println(printSubTitle("do/while loops"));
		int i = 10;
		System.out.println("While");
		while (i < 10) { // check first , execute the statement
			i++;
			System.out.println(i); // will not run
		}

		System.out.println("Do While");
		do {// execute first
			i++;
			System.out.println(i); // will run
		} while (i < 10); // check the condition later

		System.out.println(printSubTitle("The for loop"));

		for (int x = 0, y = 10; x < y; x++, y--) {
			System.out.println("X : " + String.valueOf(x) + " Y : " + String.valueOf(y));
		}

		Foo myFoo = new Foo();

		for (; myFoo.canIncrementValue();) {
			System.out.println("Value of Foo : " + String.valueOf(myFoo.getValue()));
			myFoo.incrementValue();
		}

		System.out.println(printSubTitle("The enhanced for loop"));
		int[] arrayOfInts = new int[] { 1, 2, 3, 4 };
		for (int i1 : arrayOfInts)
			System.out.println(i1);

		List<String> list = new ArrayList<String>();
		list.add("foo");
		list.add("bar");
		for (String s : list)
			System.out.println(s);

		System.out.println(printSubTitle("switch statements"));
		int value = 2;
		switch (value) {
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		}

		int value1 = TEENYWEENIE;
		switch (value1) {
		case MINISCULE:
		case TEENYWEENIE:
		case SMALL:
			System.out.println("Small");
			break;
		case MEDIUM:
			System.out.println("Medium");
			break;
		case LARGE:
		case EXTRALARGE:
			System.out.println("Large");
			break;
		}

		Size size1 = Size.Large;
		switch (size1) {
		case Small:
			System.out.println("Small");
		case Medium:
			System.out.println("Medium");
		case Large:
			System.out.println("Large");
		}

		System.out.println(printSubTitle("break/continue"));

		int condition = MINISCULE;
		while (true) {
			if (condition > MEDIUM)
				break;
			System.out.println(condition);
			condition++;
		}

		for (Size size11 : Size.values()) {
			if (size11 == Size.Medium)
				continue;
			System.out.println(size11);
		}

		unreachableStatement();

		System.out.println(printSubTitle("Assignment"));
		int a, b;
		a = (b = 5);
		System.out.println(a);
		System.out.println(b);

		String s = null;
		try {
			System.out.println(s);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(printSubTitle("Variable access and Method invocation"));

		int availableSize = Size.values().length;
		Foo adrianFoo = new Foo("Adrian");

		int len = adrianFoo.getName().length();
		int initialLen = adrianFoo.getName().substring(2, 5).length();

		System.out.println(len);
		System.out.println(initialLen);

		int hours = new Date().getHours();

		System.out.println(hours);

		System.out.println(printSubTitle("The instanceof operator"));
		Boolean b1;
		String str = "foo";
		b1 = (str instanceof String); // true, str is a String
		System.out.println(b1);
		b1 = (str instanceof Object); // also true, a String is an Object
		System.out.println(b1);
		// b = ( str instanceof Date ); // The compiler is smart enough to catch this!

		String s1 = null;
		System.out.println(s1 instanceof String); // false, null isn't an instance of anything
	}

}
