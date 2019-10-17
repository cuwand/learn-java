import java.util.*;

public class Main {

	public static void printTitle(String title) {
		System.out.println("========== " + title + " ==========");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printTitle("Bounds");
		// Failed Subtitutions
		// EmployeeList<Employee> employeeList = new EmployeeList<Employee>();
		// EmployeeList<PrintableEmployee> employeeList = new
		// EmployeeList<PrintableEmployee>();
		EmployeeList<PrintableRankedEmployee> employeeList = new EmployeeList<PrintableRankedEmployee>();

		PrintableRankedEmployee e1 = new PrintableRankedEmployee("Adrian");
		e1.setRank(1);
		employeeList.addEmployee(e1);

		PrintableRankedEmployee e2 = new PrintableRankedEmployee("Adrian2");
		e2.setRank(2);

		employeeList.addEmployee(e2);

		System.out.println(employeeList.getRanking().getRank());

		printTitle("Wildcards");

		List<?> anyInstantiationOfList = new ArrayList<Date>();
		// anyInstantiationOfList.add(new Date()); Cannot use purely wildcard class

		anyInstantiationOfList = new ArrayList<String>(); // another instantiation

		List<? extends Date> dateInstantiations = new ArrayList<Date>();
		dateInstantiations = new ArrayList<MyDate>(); // another instantiation

		printTitle("Thinking Outside the Container");
		List<?> someInstantiationOfList;
		someInstantiationOfList = new ArrayList<Date>();
		someInstantiationOfList = new ArrayList<String>();

		List<? extends Date> dateInstantiations1 = new ArrayList<Date>();
		dateInstantiations1 = new ArrayList<MyDate>(); // another instantiation

		printTitle("Lower Bounds");
		List<? super MyDate> listOfAssignableFromMyDate;
		listOfAssignableFromMyDate = new ArrayList<MyDate>();
		listOfAssignableFromMyDate = new ArrayList<Date>();
		listOfAssignableFromMyDate = new ArrayList<Object>();

		printTitle("Reading, Writing, and Arithmetic");
		List<? extends Date> someDateList = new ArrayList<MyDate>();
		// someDatelist.add( new Date() ); // Compile-time Error!
		// someDatelist.add( new MyDate() ); // Compile-time Error!

		List<? super Date> listAssignableMyDate = new ArrayList<Date>();
		listAssignableMyDate.add(new MyDate());
		listAssignableMyDate.add(new Date());

		List<? super MyDate> listAssignableMyDate1 = new ArrayList<Date>();
		listAssignableMyDate1.add(new MyDate());
		// listAssignableMyDate1.add(new Date()); // Compile-time Error!

		// Remember PECS: "Producer Extends, Consumer Super".

		// Wildcard instantiations of generic types can be read as their upper bound and
		// written as their lower bound.

		Object obj = listAssignableMyDate.get(0); // read as Object

		printTitle("<?>, <Object>, and the Raw Type");

		List<? extends Date> dateLists = new ArrayList<Date>();
		List<?> anylists;
		anylists = dateLists; // Ok!s

		printTitle("Wildcard Type Relationships");

		List<? extends Date> dateLists1 = new ArrayList<Date>();
		List<? extends Object> objectLists;
		objectLists = dateLists1; // Ok!

		System.out.println("Done");
	}

}
