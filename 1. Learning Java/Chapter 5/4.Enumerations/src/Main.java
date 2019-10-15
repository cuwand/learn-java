import java.util.ArrayList;
import java.util.List;

public class Main {

	public static String printTitle(String title) {
		return "========== " + title + " ==========";
	}

	public static String printSubTitle(String title) {
		return "--> " + title;
	}

	public static Double multiply(Double a, Double b) {
		return a.doubleValue() * b.doubleValue();
	}

	static void printObjects(Object... list) {
		// list is an Object []
		for (Object o : list)
			System.out.println(o);
	}

	public static void main(String[] args) {
		Pendulum p;

		Pendulum.PendulumType[] availablePendulumType = Pendulum.getAvailablePendulumType();
		for (int i = 0; i < availablePendulumType.length; i++) {
			System.out.println(availablePendulumType[i].toString());
		}

		Ball pendulumBall;
		pendulumBall = new Ball(2.0f);

		// pass the ball by reference
		p = new Pendulum(2, pendulumBall, Pendulum.PendulumType.ONE_SPRING);
		float pos = p.getPosition(1.0);
		p.stopSwing();

		System.out.println(pos);
		System.out.println(Pendulum.ACCELERATION_OF_GRAVITY);

		System.out.println("Pendulum Mass : " + String.valueOf(p.getMass()));

		pendulumBall.setMass(3.0f);

		// Changing mass of the ball, will affect to pendulum mass
		System.out.println("Pendulum Mass : " + String.valueOf(p.getMass()));

		System.out.println(printTitle("Wrappers for Primitive Types"));
		List<Ball> listBall = new ArrayList<Ball>();
		listBall.add(new Ball(1.0f));
		listBall.add(new Ball(2.0f));
		listBall.add(new Ball(3.0f));

		listBall.get(0).setMass(10f);
		for (Ball b : listBall) {
			System.out.println("Ball Weight : " + b.getMass());
		}

		Double size = new Double(32.76);
		double d = size.doubleValue();
		float f = size.floatValue();
		long l = size.longValue();
		int i = size.intValue();

		System.out.println(d);
		System.out.println(f);
		System.out.println(l);
		System.out.println(i);

		System.out.println(printTitle("Autoboxing and Unboxing of Primitives"));
		// Simple assignments
		Integer integer = 5;
		int i1 = new Integer(5);
		// Method arguments and return types

		double d1 = multiply(5.0, 5.0);
		System.out.println(integer);
		System.out.println(i1);
		System.out.println(d1);

		System.out.println(printTitle("Variable-Length Argument Lists"));
		System.out.printf("My name is %s and my age is %s\n", "Bob", 21); // < example of variable length
		printObjects(listBall);

		System.out.println(printTitle("Method Overloading"));
		PrintStream.print('a');
		PrintStream.print("Adrian");
		PrintStream.print(pendulumBall);

		System.out.println(printTitle("mutable and immutable objects"));
		// What is difference between mutable and immutable objects in Java?

		// 1. Mutable object – You can change the states and fields after the object is
		// created. For examples: StringBuilder, java.util.Date and etc.

		// 2. Immutable object – You cannot change anything after the object is created.
		// For examples: String, boxed primitive objects like Integer, Long and etc.

		MutableExample obj = new MutableExample("Ranjit");
		System.out.println(obj.getName());

		// update the name, this object is mutable
		obj.setName("Ranjit Paul");
		System.out.println(obj.getName());

		ImmutableExample obj1 = new ImmutableExample("Ranjit");
		System.out.println(obj1.getName());

		// there is no way to update the name after the object is created.
		// obj.setName("Ranjit Paul");
		// System.out.println(obj.getName());

		System.out.println(printTitle("Enum Values"));
		for (Weekday w : Weekday.values()) {
			System.out.println("Day : " + w.toString() + " Fun : " + w.getFun());
		}
		System.out.println("Done");
	}
}
