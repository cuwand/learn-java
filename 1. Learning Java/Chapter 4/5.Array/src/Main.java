import java.awt.Button;
import java.awt.Component;
import java.util.Arrays;

public class Main {
	public static String printTitle(String title) {
		return "========== " + title + " ==========";
	}

	public static String printSubTitle(String title) {
		return "--> " + title;
	}

	public static void printBytes(byte[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);

			if (i < data.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	public static void printBytes(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);

			if (i < data.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	enum ChessPiece {
		Rook, Pawn, Queen, King, Knight, Bishop
	};

	enum Color {
		Black, Yellow
	}

	public static void main(String[] args) {
		System.out.println(printTitle("Arrays"));

		System.out.println(printSubTitle("Array Types"));
		int[] arrayOfInts; // preferred
		int arrayOfInts1[]; // C-style

		System.out.println(printSubTitle("Array Creation and Initialization"));
		arrayOfInts = new int[42]; // create array size 42
		arrayOfInts[0] = 1;

		System.out.println(arrayOfInts);

		int number = 0;
		String[] someStrings = new String[number + 2];// create array size 2
		someStrings[0] = new String("Adrian");
		someStrings[1] = "Boofa";

		System.out.println(String.join("-", someStrings));

		double[] someNumbers = new double[20];
		Component[] widgets = new Component[12];

		int[] grades = new int[30];
		grades[0] = 99;
		grades[1] = 72;
		System.out.println(grades[2] == 0);

		String names[] = new String[4];
		names[0] = new String();
		names[1] = "Boofa";
		names[2] = someNumbers.toString();
		System.out.println(names[3] == null);

		int[] primes = { 2, 3, 5, 7, 7 + 4 };

		Object someWord = new String("OKE");

		String[] verbs = { "run", "jump", someWord.toString() };
		Button stopButton = new Button("Stops");

		Button[] controls = { stopButton, new Button("Forwards"), new Button("Backwards") };
		// All types are subtypes of Object
		Object[] objects = { stopButton, "A word", null };

		System.out.println(printSubTitle("Using Arrays"));
		char[] alphabet = new char[26];
		int alphaLen = alphabet.length;
		System.out.println(alphaLen == 26);
		String[] musketeers = { "one", "two", "three" };
		int num = musketeers.length;
		System.out.println(num == 3);

		Button[] keyPad = new Button[10];
		for (int i = 0; i < keyPad.length; i++)
			keyPad[i] = new Button(Integer.toString(i));
		for (Button b : keyPad)
			System.out.println(b);

		String[] states = new String[50];
		try {
			states[0] = "California";
			states[1] = "Oregon";
			states[50] = "McDonald's Land"; // Error: array out of bounds
		} catch (ArrayIndexOutOfBoundsException err) {
			System.out.println("Handled error: " + err.getMessage());
		}

		byte[] bar = new byte[] { 1, 2, 3, 4, 5 };
		byte[] targetBar = new byte[5];

		System.arraycopy(bar, 0, targetBar, 2, bar.length - 2);
		printBytes(targetBar);

		byte[] barCopy = Arrays.copyOf(bar, bar.length); // { 1, 2, 3, 4, 5 }
		byte[] expanded = Arrays.copyOf(bar, bar.length + 2); // { 1, 2, 3, 4, 5, 0, 0 }
		byte[] firstThree = Arrays.copyOfRange(bar, 0, 3); // { 1, 2, 3 }
		byte[] lastThree = Arrays.copyOfRange(bar, 2, bar.length); // { 3, 4, 5 }
		byte[] lastThreePlusTwo = Arrays.copyOfRange(bar, 2, bar.length + 2); // { 3, 4, 5, 0, 0 }

		printBytes(bar);
		printBytes(barCopy);
		printBytes(expanded);
		printBytes(firstThree);
		printBytes(lastThree);
		printBytes(lastThreePlusTwo);

		Dog pokey = new Dog("gray");
		Cat boojum = new Cat("grey");
		Cat simon = new Cat("orange");
		setPets(new Animal[] { pokey, boojum, simon });

		System.out.println(printSubTitle("Multidimensional Arrays"));

		ChessPiece[][] chessBoard;
		chessBoard = new ChessPiece[8][8];
		chessBoard[0][0] = ChessPiece.Rook;
		chessBoard[1][0] = ChessPiece.Pawn;

		ChessPiece[] homeRow = { ChessPiece.Rook, ChessPiece.Knight, ChessPiece.Bishop, ChessPiece.King, ChessPiece.Queen,
		    ChessPiece.Bishop, ChessPiece.Knight, ChessPiece.Rook };
		chessBoard[0] = homeRow;

		Color[][][] rgbCube = new Color[256][256][256];
		rgbCube[0][0][0] = Color.Black;
		rgbCube[255][255][0] = Color.Yellow;

		boolean[][] checkerBoard;
		checkerBoard = new boolean[8][];
		checkerBoard[0] = new boolean[8];
		checkerBoard[1] = new boolean[8];
		checkerBoard[2] = new boolean[3]; // length can be diffrent
		checkerBoard[3] = new boolean[10];
		checkerBoard[7] = new boolean[8];

		int[][] triangle = new int[5][];
		for (int i = 0; i < triangle.length; i++) {
			triangle[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++)
				triangle[i][j] = i + j;
		}

		for (int i = 0; i < triangle.length; i++) {
			printBytes(triangle[i]);
		}
		
		System.out.println("Done");
	}

	private static void setPets(Animal[] animals) {
		for (Animal a : animals) {
			System.out.println(a.getName());
		}
	}
}
