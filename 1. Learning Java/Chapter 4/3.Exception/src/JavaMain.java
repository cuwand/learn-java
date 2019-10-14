import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.ZipException;

import javax.net.ssl.SSLException;

public class JavaMain {

	public static String printTitle(String title) {
		return "========== " + title + " ==========";
	}

	public static String printSubTitle(String title) {
		return "--> " + title;
	}

	// Bubbling Up
	private static void readUsingScanner(String fileName) throws Exception {
		Path path = Paths.get(fileName);
		Scanner scanner = new Scanner(path);
		System.out.println("Read text file using Scanner");
		// read line by line
		while (scanner.hasNextLine()) {
			// process each line
			String line = scanner.nextLine();
			System.out.println(line);
		}
		scanner.close();
	}

	// Checked and Unchecked Exceptions : where's the throws
	// SecruityException is Unchecked Exception
	public static void checkRead(String s) {
		if (!new File(s).isAbsolute() || (s.indexOf("..") != -1))
			throw new SecurityException("Access to file : " + s + " denied.");
	}

	// Here's another Unchecked Exception
	public static void uncheckedException() {
		int x = 0;
		int y = 10;
		int z = y / x;
	}

	public static void throwCustomException() throws CustomException {
		throw new CustomException();
	}

	public static void chainingException() throws Exception {
		try {
			throwCustomException();
		} catch (Exception cause) {
			// we can change custom exception to new one;
			// log(cause); // Log it
			Exception e = new IOException("What we have here is a failure...");
			e.initCause(cause);
			throw e;
		}
	}

	public static void myMethod() {
		int foo;
		try {
			foo = 1;
		} catch (Exception e) {
			System.out.println("Handle all other errors: " + e);
		}
		// int bar = foo; // Compile-time error: foo may not have been initialized
	}

	public static void myMethod2() {
		int foo;
		try {
			foo = 1;
			int bar = foo;
			// Okay because we get here only
			// if previous assignment succeeds
		} catch (Exception e) {
			System.out.println("Handle all other errors: " + e);
		}
	}

	// find the difference from myMethod()
	public static void myMethod3() {
		int foo;
		try {
			foo = 1;
		} catch (Exception e) {
			System.out.println("Handle all other errors: " + e);
			return;
		}
		int bar = foo;
		// Okay because we get here only
		// if previous assignment succeeds
	}

	public static void main(String args[]) {
		// Catch General Error
		try {
			readUsingScanner("foo");
		} catch (Exception e) {
			// Handle error
			System.out.println("Exception while reading file: " + e);
		}

		// Catch Specific Error
		try {
			readUsingScanner("foo");
		} catch (FileNotFoundException e) {
			// Handle file not found
			System.out.println("Handle file not found: " + e);
		} catch (IOException e) {
			// Handle read error
			System.out.println("Handle read error: " + e);
		} catch (Exception e) {
			// Handle all other errors
			System.out.println("Handle all other errors: " + e);
		}

		// Catch Specific Error
		try {
			readUsingScanner("foo");
		} catch (Exception e) {
			// Handle all other errors
			System.out.println("Handle all other errors: " + e);
		} // catch (FileNotFoundException e) {
		  // Handle file not found
		  // System.out.println("Handle file not found: " + e);
		  // } catch (IOException e) {
		  // Handle read error
		  // System.out.println("Handle read error: " + e);
		  // }
		  // Will cause error, place general Execption on the lowest order

		// Catch Multiple Specific Error
		try {
			readUsingScanner("foo");
		} catch (ZipException | SSLException e) {
			// Handle file not found
			System.out.println("Handle file not found: " + e);
		} catch (IOException e) {
			// Handle read error
			System.out.println("Handle read error: " + e);
		} catch (Exception e) {
			// Handle all other errors
			System.out.println("Handle all other errors: " + e);
		}

		try {
			// complex, deeply nested task
			readUsingScanner("foo");
		} catch (Exception e) {
			// dump information about exactly where the exception occurred
			e.printStackTrace(System.err);
		}

		System.out.println(printTitle("Checked and Unchecked Exceptions"));
		try {
			checkRead("foo");
		} catch (Exception e) {
			// Handle error
			System.out.println("Exception while reading file: " + e);
		}

		try {
			uncheckedException();
		} catch (Exception e) {
			// Handle error
			System.out.println("Exception while reading file: " + e);
		}
		System.out.println(printTitle("Throwing Exceptions"));

		try {
			throw new IOException("Sunspots!");
		} catch (Exception e) {
			// Handle error
			System.out.println("Catch Exception: " + e);
		}

		try {
			throwCustomException();
		} catch (Exception e) {
			// Handle error
			System.out.println("Catch custom Exception: " + e);
		}

		System.out.println(printSubTitle("Chaining and rethrowing exceptions"));

		try {
			chainingException();
		} catch (Exception e) {
			// Handle error
			System.out.println("Catch custom Exception: " + e);
		}

		System.out.println(printSubTitle("try Creep"));
		// See Function Below
		myMethod();
		myMethod2();
		myMethod3();

		System.out.println(printSubTitle("The finally Clause"));
		try {
			chainingException();
		} catch (Exception e) {
			// Handle error
			System.out.println("Catch custom Exception: " + e);
		} finally {
			System.out.println("This Always Executed");
			// clean up conenction, file descriptor, etc
		}

		// This is the best practice rather than use finally to clean up the resource
		System.out.println(printSubTitle("Try with Resources"));

		try (Socket sock = new Socket("128.252.120.1", 80); FileWriter file = new FileWriter("foo");) {
			// work with sock
		} catch (IOException e) {
			System.out.println("Catch Exception: " + e);
		}

		// Performance Issues
		// - using try is free
		// - throw exception consuming resource

		System.out.println("Done");
	}
}