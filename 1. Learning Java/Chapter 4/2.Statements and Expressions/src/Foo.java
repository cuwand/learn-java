
public class Foo {
	private int value;
	private int maxValue;
	private String name;

	private void setBasicValue() {
		value = 0;
		maxValue = 10;
	}

	public Foo() {
		setBasicValue();
	}

	public Foo(String name) {
		setBasicValue();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public boolean canIncrementValue() {
		if (value < maxValue) {
			return true;
		}

		return false;
	}

	public void incrementValue() {
		value += 1;
	}

	public int getValue() {
		return value;
	}

}
