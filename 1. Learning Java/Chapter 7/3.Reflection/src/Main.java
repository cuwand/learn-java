import java.lang.reflect.*;
import java.util.Date;
import java.util.List;

public class Main {

	public static void printTitle(String title) {
		System.out.println("========== " + title + " ==========");
	}

	public static void main(String[] args) {
		printTitle("Modifiers and Security");
		Method method;
		try {
			method = Object.class.getDeclaredMethod("clone");

			int perms = method.getModifiers();
			System.out.println(Modifier.isPublic(perms)); // false
			System.out.println(Modifier.isProtected(perms)); // true
			System.out.println(Modifier.isPrivate(perms)); // false
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // no arguments

		printTitle("Accessing Fields");
		BankAccount myBankAccount = new BankAccount();
		try {
			Field balanceField = BankAccount.class.getField("balance");
			// read it
			int mybalance = balanceField.getInt(myBankAccount);
			// change it
			balanceField.setInt(myBankAccount, 42);

			System.out.println("My Bank Balance " + myBankAccount.balance);
		} catch (NoSuchFieldException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e2) {
			System.out.println(e2.getMessage());
		}

		printTitle("Accessing Methods");

		Invoke.inspect(new String[] { "java.lang.System", "currentTimeMillis" });
		Invoke.inspect(new String[] { "java.lang.System", "currentTimeMilliss" });

		printTitle("Accessing Constructors");
		try {
			Constructor<Date> cons = Date.class.getConstructor(String.class);
			Date date = cons.newInstance("Jan 1, 2006");
			System.out.println(date);
		} catch (NoSuchMethodException e) {
			System.out.println("getConstructor() couldn't find the constructor we described : " + e.getMessage());
		} catch (InstantiationException e2) {
			System.out.println("The class is abstract : " + e2.getMessage());
		} catch (IllegalAccessException e3) {
			System.out.println("We don't have permission to create an instance" + e3.getMessage());
		} catch (InvocationTargetException e4) {
			System.out.println("The construct threw an exception" + e4.getMessage());
		}

		printTitle("Accessing Generic Type Information");
		// public interface List<E> extends Collection<E> { ... }
		TypeVariable[] tv = List.class.getTypeParameters();
		System.out.println(tv[0].getName()); // "E"

		Type type = StringList.class.getGenericSuperclass();
		System.out.println(type); // "java.util.ArrayList<java.lang.String>"
		ParameterizedType pt = (ParameterizedType) type;
		System.out.println(pt.getActualTypeArguments()[0]); // "class java.lang.String"

		System.out.println("Done");
	}
}
