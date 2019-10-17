import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {

	public static void printTitle(String title) {
		System.out.println("========== " + title + " ==========");
	}

	static List<String> useLists(String... lists) {
		List<String> data = new ArrayList<String>();

		for (int i = 0; i < lists.length; i++) {
			data.add(lists[i]);
		}
		return data;
	}

	static <T extends Comparable<? super T>> void sort(List<T> list) {
		Collections.sort(list, new Comparator<T>() {
			@Override
			public int compare(T arg0, T arg1) {
				return arg0.compareTo(arg1);
			}

		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = new String[5];
		Object[] objects = strings;

		try {
			objects[0] = new Date(); // Runtime ArrayStoreException!
		} catch (Exception e) {
			System.out.println(e);
		}

		printTitle("Using Array Types");
		Trap<Mouse>[] tma = new Trap[10]; // unchecked warning
		Trap<Mouse> tm = new Trap<Mouse>();
		tma[0] = tm;
		Trap<Mouse> again = tma[0];
		System.out.println(again);

		printTitle("What Good Are Arrays of Generic Types?");
		// Why does Java even let us declare arrays of generic types? One important
		// usage is that it allows generic types to be used in variable-length argument
		// methods.
		// Another answer is that it’s an escape hatch to preserve our ability to use
		// arrays when necessary
		String[] ss = new String[] { "AS", "ASS" };
		List<String> ls = useLists(ss);

		System.out.println(ss);
		System.out.println(ls);

		printTitle("Wildcards in Array Types");
		ArrayList<?>[] arrayOfArrayLists = new ArrayList<?>[10];
		arrayOfArrayLists[0] = new ArrayList<Date>();
		arrayOfArrayLists[1] = new ArrayList<String>();

		ArrayList<?>[] arrayOfArrayLists1 = new ArrayList<?>[10];
		arrayOfArrayLists1[0] = new ArrayList<Date>();
		Trap<?>[] arrayOfTraps = new Trap<?>[10];
		arrayOfTraps[0] = new Trap<Mouse>();

		printTitle("Case Study: The Enum Class");

		printTitle("Case Study: The sort() Method");

		List<ComparableBear> listComparableBear = new ArrayList<ComparableBear>();
		listComparableBear.add(new ComparableBear("Eka"));
		listComparableBear.add(new ComparableBear("Adrian"));
		listComparableBear.add(new ComparableBear("Sanjaya"));

		System.out.println(listComparableBear);
		sort(listComparableBear);
		System.out.println(listComparableBear);
	}

}
