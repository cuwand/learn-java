
public class Main {

	private static final String LEFT = "left";
	private static final String RIGHT = "right";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Bad For Assertion
		try {
			if (false)
				throw new AssertionError("fatal error: 42");
		} catch (Exception e) {
			System.out.println("Throw e: " + e.getMessage());
		}

		int array[] = { 1, 2, 3, 4 };
		int min = 5;
		int a = -1;
		String foo = "OKE";

		assert false : "false";
		assert (array.length > min);
		assert a > 0 : a; // shows value of a to the user
		assert foo != null : "foo is null!"; // shows message "foo is null!" to user

		// Enabling Assertions
		// 1. Go to the menu Run, and then to the menu item Run Configurations.
		// 2. In the left panel, go to Java Application, and then go to Assertions.
		// 3. In the right panel, choose the tab Arguments.
		// 4. Under the field for VM arguments, type -ea to enable assertions.
		// 5. Click on the Apply and then Run button.

		String direction = "Unknown";
		if (direction == LEFT)
			System.out.println(LEFT);
		else if (direction == RIGHT)
			System.out.println(RIGHT);
		else
			assert false : "bad direction";

		switch (direction) {
		case LEFT:
			System.out.println(LEFT);
			break;
		case RIGHT:
			System.out.println(RIGHT);
			break;
		default:
			assert false;
		}
		System.out.println("Done");
	}

}
