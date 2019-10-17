import sun.misc.Unsafe;

public class Main {

	public static void printTitle(String title) {
		System.out.println("========== " + title + " ==========");
	}

	public static void main(String[] args) {
		Answer theAnswer = new Answer("Coba");
		MyObj myObject = new MyObj();
		System.out.println(myObject);
		String s = "The answer is: " + theAnswer;
		System.out.println(s);

		printTitle("Equality and Equivalence");
		String userName = new String("Joe");
		String suspectName = new String("Joe");
		if (userName.equals(suspectName))
			System.out.println("userName.equals(suspectName)");
		if (userName == suspectName)
			System.out.println("if ( userName == suspectName )");

		String userName1 = "Joe";
		String suspectName1 = "Joe";
		if (userName1.equals(suspectName1))
			System.out.println("userName1.equals(suspectName1)");
		if (userName1 == suspectName1)
			System.out.println("if ( userName1 == suspectName1 )");

		System.out.printf("identityHashCode of userName : %x\n", System.identityHashCode(userName));
		System.out.printf("identityHashCode of suspectName : %x\n", System.identityHashCode(suspectName));

		System.out.printf("identityHashCode of userName1 : %x\n", System.identityHashCode(userName1));
		System.out.printf("identityHashCode of suspectName1 : %x\n", System.identityHashCode(suspectName1));

		// So == is stand for identity not equality

		Sneakers s1 = new Sneakers(10);
		Sneakers s2 = new Sneakers(12);
		Sneakers s3 = new Sneakers(10);

		if (s1.equals(s3)) {
			System.out.println("s1.equals(s3)");
		}

		if (s1.equals(s2)) {
			System.out.println("s1.equals(s2)");
		}
		if (s1 == s3) {
			System.out.println("s1 == s3");
		}

		printTitle("Hashcodes");
		System.out.printf("HashCode of s1 : %d\n", s1.hashCode());
		System.out.printf("HashCode of s2 : %d\n", s2.hashCode());
		System.out.printf("HashCode of s3 : %d\n", s3.hashCode());

		printTitle("Cloning Objects");
		Sheep one = new Sheep();
		Sheep anotherOne = one.clone();

		System.out.println("Sheep one and anotherOne is same : " + String.valueOf(one == anotherOne));
		// Still Refer to the same HashMap object
		System.out
				.println("Flock Sheep one and anotherOne is same : " + String.valueOf(one.getFlock() == anotherOne.getFlock()));

		DeepSheep deepOne = new DeepSheep();
		DeepSheep anotherDeepOne = deepOne.clone();

		System.out.println("Sheep deepOne and anotherDeepOne is same : " + String.valueOf(deepOne == anotherDeepOne));
		System.out.println("Flock Sheep deepOne and anotherDeepOne is same : "
				+ String.valueOf(deepOne.getFlock() == anotherDeepOne.getFlock()));
		System.out.println("Done");
	}
}
