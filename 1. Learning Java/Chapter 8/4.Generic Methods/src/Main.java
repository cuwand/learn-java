import java.util.*;

public class Main {
//generic method
	static <T> T cache(T entry) {
		System.out.println(entry);
		return entry;
	}

	public static void printTitle(String title) {
		System.out.println("========== " + title + " ==========");
	}

	static <T> Trap<T> makeTrap() {
		return new Trap<T>();
	}

	static <T> Set<T> listToSet(List<T> list) {
		Set<T> set = new HashSet<T>();
		set.addAll(list);
		return set;
	}

	// Wildcard Types Versus Generic Methods
	// Bad implementation
	List<?> swap(List<?> list) {
		Object tmp = list.get(0);
		// list.set(0, list.get(1)); // error, can't write
		// list.set(1, tmp); // error, can't write
		return list;
	}

	static <T> List<T> swapGeneric(List<T> list) {
		T tmp = list.get(0);
		list.set(0, list.get(1));
		list.set(1, tmp);
		return list;
	}

	public static void main(String[] args) {
		printTitle("Generic Methods");
		BlogEntry newBlogEntry = new BlogEntry();
		NewspaperEntry newNewspaperEntry = new NewspaperEntry();

		printTitle("Generic Methods Introduced");
		BlogEntry oldEntry = cache(newBlogEntry);
		NewspaperEntry old = cache(newNewspaperEntry);

		printTitle("Type Inference from Arguments");
		Number max = MathUtils.max(1, 2);
		System.out.println(max);

		// usage
		Trap<Mouse> mouseTrap = makeTrap();
		Trap<Bear> bearTrap = makeTrap();
		System.out.println(mouseTrap);
		System.out.println(bearTrap);

		printTitle("Explicit Type Invocation");
		Integer i = MathUtils.<Integer>max(42, 42);

		printTitle("Wildcard Capture");
		// usage
		List<Date> list = new ArrayList<Date>();
		list.add(new Date());
		list.add(new Date());
		list.add(new Date());
		System.out.println(list);
		Set<Date> set = listToSet(list);

		printTitle("Wildcard Types Versus Generic Methods");

		List<Integer> li = new ArrayList<Integer>();
		li.add(1);
		li.add(2);
		li.add(3);

		System.out.println(li);
		List<Integer> swapLi = swapGeneric(li);

		System.out.println(swapLi);
		System.out.println(set);
	}
}
