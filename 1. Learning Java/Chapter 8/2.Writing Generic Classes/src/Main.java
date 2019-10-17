import java.util.Date;
import java.util.List;

public class Main {

	public static void printTitle(String title) {
		System.out.println("========== " + title + " ==========");
	}

	public static void main(String[] args) {

		printTitle("The Type Variable");
		Trap<Mouse> mouseTrap = new Trap<Mouse>();
		mouseTrap.snare(new Mouse());
		Mouse mouse = mouseTrap.release();

		System.out.println(mouse);

		printTitle("Subclassing Generics");
		DateList dateList = new DateList();
		dateList.add(new Date());
		List<Date> ld = dateList;
		System.out.println(ld.get(0));

		AdjustableTrap<Mouse> adjustableMouseTrap = new AdjustableTrap<Mouse>();
		adjustableMouseTrap.snare(new Mouse());
		Mouse mouse1 = adjustableMouseTrap.release();
		System.out.println(mouse1);

		printTitle("Exceptions and Generics");
		try {
			new ExceptionTester<ClassNotFoundException>().test(new ClassNotFoundException());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getStackTrace());
		}

		printTitle("Parameter Type Limitations");
		// T element = new T();// Error! Invalid syntax.

		ExceptionTester<ArithmeticException> et = new ExceptionTester<ArithmeticException>();
		et.test(new ArithmeticException()); // no other .class will work
		//et.test(ArithmeticException.class); // no other .class will work
		System.out.println("Done");
	}
}
