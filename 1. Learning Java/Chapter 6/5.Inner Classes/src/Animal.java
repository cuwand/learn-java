
public class Animal {
	public int size;

	public Animal() {
		this.size = 10;
	}

	public Animal(int size) {
		this.size = size;
	}

	class Brain {
		int brainSize;

		public Brain() {
			System.out.printf("Animal.this.size >> %d\n", Animal.this.size);
			// Scoping of the “this” reference
			this.brainSize = Animal.this.size;
		}

		void disgustingMethod() {
			// Well, which instance of Animal ? If we have several Animal objects around
			// (say, a few Cat s and Dog s), we need to know whose performBehavior() method
			// we are calling.

			// What does it mean for a class definition to be “inside” another class
			// definition? The answer is that a Brain object always lives within a single
			// instance of Animal : the one that it was told about when it was created.
			// We’ll call the object that contains any instance of Brain its enclosing
			// instance.
			performBehavior();
		}
	}

	private Brain brain;

	public Brain getBrain() {
		return brain;
	}

	public void setBrain(Brain brain) {
		this.brain = brain;
	}

	void performBehavior() {
		System.out.println("It's to abstract");
	}
}
