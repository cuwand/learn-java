
public class Main {
	public static String printTitle(String title) {
		return "========== " + title + " ==========";
	}

	public static String printSubTitle(String title) {
		return "--> " + title;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat simon = new Cat(10, 10, true);
		Animal creature = simon;
		Mammal mammalCreature = simon;
		System.out.println(mammalCreature.getHeartRate());
		System.out.println(simon.getHeartRateDetail());
		System.out.println(simon.getHeartRate()); // this method will refer to its parent

		OverridenCat overridenSimon = new OverridenCat(10, 10, true);
		Animal overridenCreature = simon;
		Mammal overridenMammalCreature = simon;
		System.out.println(overridenMammalCreature.getHeartRate());
		System.out.println(overridenSimon.getHeartRateDetail());
		System.out.println(overridenSimon.getHeartRate()); // this method will refer to its parent

		Animal creature1 = new Animal(10);
		Cat simon1;
		// simon = creature; // Compile-time error, incompatible type

		try {
			simon1 = (Cat) creature1; // OK at Compile Time, not at run time
			System.out.println(simon1.isLongHair());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// creature 1 is not a Cat
		if (creature1 instanceof Cat) {
			Cat cat = (Cat) creature1;
			System.out.println(cat.isLongHair());
		}

		if (overridenCreature instanceof Cat) {
			Cat cat = (Cat) overridenCreature;
			System.out.println(cat.isLongHair());
		}

		System.out.println(printTitle("Abstract Class"));
		// We cannot instantiated abstract class
		//LivingCreature l = new LivingCreature();
		
		People p = new People();
		
		p.walk();
		p.killMe();
		System.out.println("Done");
	}
}
