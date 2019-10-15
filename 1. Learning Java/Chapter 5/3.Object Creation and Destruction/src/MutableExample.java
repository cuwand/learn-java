public class MutableExample {

	private String name;

	public MutableExample(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// this setter can modify the name
	public void setName(String name) {
		this.name = name;
	}

}