import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Main {

	public static void printTitle(String title) {
		System.out.println("========== " + title + " ==========");
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		printTitle("Containers: Building a Better Mousetrap");
		Date date = new Date();
		List list = new ArrayList();
		list.add(date);
		Date firstElement = (Date) list.get(0); // Is the cast correct? Maybe.
		System.out.println(firstElement);

		printTitle("Can Containers Be Fixed?");
		FixedTypeArrayList fl = new FixedTypeArrayList();
		fl.add(date);// only overload it
		fl.add("st");// still can add another string

		System.out.println(fl.get(0));
		System.out.println(fl.get(1));

		// Moving along, we might take on a bigger task. For example, we might write our
		// own DateList class that does not extend ArrayList , but rather delegates the
		// guts of it methods to the ArrayList implementation. With a fair amount of
		// tedious work, that would get us an object that does everything a List does
		// but that works with Date s. However, we’ve now shot ourselves in the foot
		// because our container is no longer an implementation of List and we can’t use
		// it interoperably with all of the utilities that deal with collections, such
		// as Collections . sort() , or add it to another collection with the Collection
		// addAll() method.

		printTitle("Enter Generics");
		List<String> listOfStrings = new ArrayList<String>();
		listOfStrings.add("eureka!");

		String s = listOfStrings.get(0); // "eureka! "
		System.out.println("Content of s : " + s);
		// listOfStrings.add(date); //compile time error

		Map<Integer, String> employees = new HashMap<Integer, String>();
		Integer bobsId = 1;
		String bob = "bob";
		employees.put(bobsId, bob);
		String employee = employees.get(bobsId);
		System.out.println("Employee Name of id " + bobsId + " is : " + employee);

		printTitle("Erasure");
		List<Date> dateList = new ArrayList<Date>();
		System.out.println(dateList instanceof List); // true!
		// dateList.add(new Object()); // Compile-time Error!

		// Since there are no actual differentiable classes for different
		// parameterizations of List at runtime, there is no way for the instanceof
		// operator to tell the difference between one incarnation of List and another
		// System.out.println(dateList instanceof List<Date>); // Compile-time Error!

		// We can’t have a class that implements two different generic List
		// instantiations because they are really the same type at runtime and there is
		// no way to tell them apart

		// abstract class DualList implements List<String>, List<Date> {
		// }

		printTitle("Raw Types");
		// nongeneric Java code using the raw type
		List rawList = new ArrayList(); // assignment ok
		rawList.add("foo"); // Compiler warning on usage of raw type

		// Date is called the upper bound of this type, meaning that it is the top of
		// the object hierarchy here and the type can be instantiated only on type Date
		// or on “lower” (more Fderived) types.
		Bounded<Date> bd = new Bounded<Date>();
		bd.addElement(new Date());
		bd.addElement(new CustomDate());

		Bounded<CustomDate> bcd = new Bounded<CustomDate>();
		// bcd.addElement(new Date()); // remember "current" or lower, compile error
		bcd.addElement(new CustomDate());

		printTitle("Parameterized Type Relationships");

		List<Date> dates = new ArrayList(); // unchecked warning

		// List<Date> dates = new ArrayList<String>(); // Compile-time Error!
		Collection<Date> cd;
		List<Date> ld = new ArrayList<Date>();
		cd = ld; // Ok!

		List<Object> lo;
		List<Date> ld1 = new ArrayList<Date>();
		// lo = ld1; // Compile-time Error! Incompatible types.

		Object o = new Date();// we can do this, but Why Isn’t a List<Date> a List<Object>
		System.out.println(o);
		printTitle("Why Isn’t a List<Date> a List<Object>?");

		// If we could assign our DateList to an ObjectList variable, we would have to
		// be able to use Object methods to insert elements of types other than Date
		// into it.
		// In general, we’d like to catch type errors at compile time
		List<Date> dateList1 = new ArrayList<Date>();
		// List<Object> objectList = dateList1; // Can't really do this
		// objectList.add( new Foo() ); // should be runtime error!

		Date[] arrDates = new Date[10];
		Object[] objects = arrDates;
		try {
			objects[0] = "not a date"; // Runtime ArrayStoreException!
		} catch (Exception e) {
			System.out.println("Cannot add : " + e.getMessage());
		}

		printTitle("Casts");
		List dlist = new ArrayList<Date>();
		List<Date> dl = list; // unchecked warning

		Collection<Date> cd1 = new ArrayList<Date>();
		List<Date> ld11 = (List<Date>) cd1; // Ok!

		Collection<Date> cd11 = new TreeSet<Date>();
		try {
			List<Date> ld111 = (List<Date>) cd11; // Runtime ClassCastException!
			ld111.add(new Date());
		} catch (Exception e) {
			System.out.println("Cannot add : " + e.getMessage());
		}
	}

}
