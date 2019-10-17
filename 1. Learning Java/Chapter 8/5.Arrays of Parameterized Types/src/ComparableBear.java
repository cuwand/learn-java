
public class ComparableBear implements Comparable<ComparableBear> {
	String name;

	public ComparableBear(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(ComparableBear arg0) {
		// TODO Auto-generated method stub
		return this.name.compareTo(arg0.name);
	}

	public String toString() {
		return name;
	}
}
