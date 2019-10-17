import java.lang.reflect.*;

//TODO:: Implements invoke with object , not the static
public class Invoke {
	public static void inspect(String[] args) {
		try {
			Class clas = Class.forName(args[0]);
			Method method = clas.getMethod(args[1]); // Named method,
			// no arguments
			Object ret = method.invoke(null); // Invoke a static method
			System.out
					.println("Invoked static method: " + args[1] + " of class: " + args[0] + " with no args\nResults: " + ret);
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName() can't find the class : " + e.getMessage());
		} catch (NoSuchMethodException e2) {
			System.out.println("That method doesn't exist : " + e2.getMessage());
		} catch (IllegalAccessException e3) {
			System.out.println("We don't have permission to invoke that method : " + e3.getMessage());
		} catch (InvocationTargetException e4) {
			// an exception occurred while invoking that method
			System.out.println("Method threw an: " + e4.getTargetException());
		}
	}
}
