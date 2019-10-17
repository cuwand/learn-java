
public class PrintableEmployee extends Employee implements Printable {

	public PrintableEmployee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("My Name is " + this.name);
	}

}
