public class MyApplication {
	String outputDeviceName = "Printer";

	public void printData() {
		try {
			Class newClass = Class.forName(outputDeviceName);
			Typewriter device = (Typewriter) newClass.newInstance();

			device.typeLine("Hello...");
		} catch (Exception e) {
			System.out.println("Cannot Found Class " + e.getMessage());
		}
	}
}