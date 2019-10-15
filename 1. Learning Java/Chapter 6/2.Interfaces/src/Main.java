
public class Main {
	public static void printTitle(String title) {
		System.out.println("========== " + title + " ==========");
	}

	public static String printSubTitle(String title) {
		return "--> " + title;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car(10);

		car.startEngine();

		printTitle("Interfaces as Callbacks");

		TextSource ts = new TextSource(new TickerTape());
		ts.sendText("HELLO");

		printTitle("Interface Variables");

		Box b = new Box(Scaleable.BIG);

		System.out.println("Box Weight : " + String.valueOf(b.getWeight()));

		printTitle("Subinterfaces");

		DynamicBox db = new DynamicBox(Scaleable.BIG);
		db.changeScale(100);

		System.out.println("DynamicBox Weight : " + String.valueOf(db.getWeight()));
		System.out.println("Done");
	}

}
