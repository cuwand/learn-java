import java.util.Iterator;

public class Main {
	public static void printTitle(String title) {
		System.out.println("========== " + title + " ==========");
	}

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

		printTitle("Inner Classes as Adapters");

		Employee[] employees = new Employee[100];
		employees[0] = new Employee("Adrian", 30);
		employees[1] = new Employee("Adrian 2", 31);
		employees[2] = new Employee("Adrian 3", 32);

		EmployeeList employeeList = new EmployeeList(employees);

		EmployeeList.Iterator EmployeeIterator = employeeList.getIterator();
		while (EmployeeIterator.hasNext()) {
			Employee curr = EmployeeIterator.next();
			System.out.println(curr.getName());
		}

		printTitle("Inner Classes Within Methods");
		Object employeeBrain = employees[0].generateBrain(true);
		System.out.println(employeeBrain);

		printTitle("Static inner classes");
		Employee.MigrationPattern stlToSanFrancisco = new Employee.MigrationPattern();

		printTitle("Anonymous inner classes");
		Iterator AnonymousEmployeeIterator = employeeList.getAnonymousIterator();

		while (AnonymousEmployeeIterator.hasNext()) {
			Employee curr = (Employee) AnonymousEmployeeIterator.next();
			System.out.println(curr.getName());
		}
		System.out.println("Done");
	}
}
