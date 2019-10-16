
public class Employee {
	private String name;
	private int age;

	static class MigrationPattern {

	}

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Object generateBrain(boolean nocturnal) {
		// How to utilize this
		class Brain {
			boolean nocturnal;

			Brain(boolean nocturnal) {
				this.nocturnal = nocturnal;
			}

			public boolean isNocturnal() {
				return nocturnal;
			}

			public void setNocturnal(boolean nocturnal) {
				this.nocturnal = nocturnal;
			}

			void sleep() {
				if (nocturnal) {
					System.out.println("Still Working");
					return;
				}
				System.out.println("Go to Sleep");
			}
		}

		Brain b = new Brain(nocturnal);
		return b;
	}
}
