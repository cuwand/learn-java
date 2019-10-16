
public class Main {
	public static void main(String[] args) {
		Animal monkey = new Animal();
		Animal.Brain monkeyBrain = monkey.new Brain();

		try {
			monkey.getBrain().disgustingMethod();
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Brain not yet initialized");
		}
		monkey.setBrain(monkeyBrain);

		monkey.getBrain().disgustingMethod();

		Cat cat = new Cat();
		// Wow it's suit
		Animal.Brain catBrain = cat.new Brain();

		cat.setBrain(catBrain);
		cat.getBrain().disgustingMethod();

		System.out.println("Done");
	}
}
