import java.util.Date;

class Bounded<E extends Date> {
	public void addElement(E element) {
		System.out.println("Add Element >> " + element);
	}
}