
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal[][] animals;
		Bird[][] birds = new Bird[10][10];
		birds[0][0] = new Bird();
		// make animals and birds reference the same array object
		animals = birds;
		observe(animals[0][0]);
		// processes Bird object
		if (birds instanceof Animal[][]) {
			System.out.println("Birds is Animal");
		}

		Object obj = animals;
		Animal[][] animals2 = (Animal[][]) obj;

		// The Compiler did not know the object is not an String, because String is
		// Object too
		// This will cause run time error
		String[][] unknownString = (String[][]) obj;
	}

	private static void observe(Object obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
	}

}
