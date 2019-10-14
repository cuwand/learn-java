
public class Types {
	public static String printTitle(String title) {
		return "========== " + title + " ==========";
	}

	public static String printSubTitle(String title) {
		return "--> " + title;
	}

	public static void main(String[] args) {
		System.out.println(printTitle("Types"));
		// Primitive
		// Type ---| Definition
		// boolean | true or false
		// char ---| 16-bit, Unicode character
		// byte ---| 8-bit, signed, two’s complement integer
		// short --| 16-bit, signed, two’s complement integer
		// int ----| 32-bit, signed, two’s complement integer
		// long ---| 64-bit, signed, two’s complement integer
		// float --| 32-bit, IEEE 754, floating-point value
		// double -| 64-bit, IEEE 754

		{
			int foo;
			double d1, d2;
			boolean isFun;

			// Will Get Error, Must Be Initialized
			/*
			 * System.out.println(foo); System.out.println(d1); System.out.println(d2);
			 * System.out.println(isFun);
			 */
		}

		{
			int foo = 42;
			double d1 = 3.14, d2 = 2 * 3.14;
			boolean isFun = true;

			System.out.println(foo);
			System.out.println(d1);
			System.out.println(d2);
			System.out.println(isFun);
		}

		{
			System.out.println(printSubTitle("Integer literals"));

			int i = 1230;
			System.out.println(i);

			i = 01230; // octal (base 8)
			System.out.println(i);

			i = 0xFFFF; // hexa (base 16)
			System.out.println(i);

			long l = 13L;
			long l2 = 13; // equivalent: 13 is converted from type int
			System.out.println(l);
			System.out.println(l2);

			byte b2 = 10;
			int i2 = 10;
			int result = b2 * i2; // b is promoted to int before multiplication
			System.out.println(result);

			int i3 = 13;
			// byte b3 = i3; // Compile-time error, explicit cast needed
			byte b3 = (byte) i3;// OK
			System.out.println(b3);

			int RICHARD_NIXONS_SSN = 567_68_0515;
			int for_no_reason = 1___2___3;
			int JAVA_ID = 0xCAFE_BABE;

			System.out.println(RICHARD_NIXONS_SSN);
			System.out.println(for_no_reason);
			System.out.println(JAVA_ID);
		}

		{
			System.out.println(printSubTitle("Floating-point literals"));
			double d = 8.31;
			double e = 3.00e+8; // Mean 3 * 10^8
			float f = 8.31F;
			float g = 3.00e+8F; // Mean 3 * 10^8
			float pi = (float) 3.14_159_265_358;

			System.out.println(d);
			System.out.println(e * 2);
			System.out.println(f);
			System.out.println(g == 300000000);
			System.out.println(pi);
		}
		{
			System.out.println(printSubTitle("Character literals"));
			char a = 'a';
			char newline = '\n';
			char smiley = '\u263a';

			System.out.println(a);
			System.out.println(newline);
			System.out.println(smiley);
		}

		{
			System.out.println(printSubTitle("Reference Types"));

			// There are now two identical references : myFoo and anotherFoo , but only one
			// actual Foo object instance
			Foo myFoo = new Foo("Adrian");
			Foo anotherFoo = myFoo;

			System.out.println(anotherFoo.getName());
		}
		{
			System.out.println(printTitle("A Word About Strings"));

			System.out.println("Hello, World...");
			String s = "I am the walrus...";
			String t = "John said: \"I am the walrus...\"";
			String quote = "Four score and " + "seven years ago,";
			String more = quote + " our" + " fathers" + " brought...";

			System.out.println(s);
			System.out.println(t);
			System.out.println(quote);
			System.out.println(more);
		}
	}
}
