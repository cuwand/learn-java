
public class Printer implements Typewriter {
	final String DEFAULT_PREFIX = "Default prefix : ";
	String prefix;

	Printer() {
		System.out.println("Default Constructor Called..");
		this.prefix = DEFAULT_PREFIX;
	}

	Printer(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public void typeLine(String s) {
		// TODO Auto-generated method stub
		System.out.println(this.prefix + s);
	}

}
