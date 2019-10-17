
public class Sneakers extends Shoes {

	public Sneakers(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}

	public boolean equals(Object arg) {
		if (arg == null) {
			return false;
		}

		if (!(arg instanceof Sneakers)) {
			return false;
		}

		Sneakers s = (Sneakers) arg;

		if (this.size != s.size) {
			return false;
		}

		return true;
	}

}
