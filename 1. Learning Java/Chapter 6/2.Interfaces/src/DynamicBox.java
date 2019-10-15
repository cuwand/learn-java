
public class DynamicBox implements DynamicallyScaleable {

	float weight;

	public DynamicBox(int size) {
		setScale(size);
	}

	@Override
	public void hurray() {
		// TODO Auto-generated method stub
		System.out.println("Hurray");
	}

	public float getWeight() {
		return weight;
	}

	public void setScale(int size) {
		switch (size) {
		case BIG:
			weight = 10;
		case MEDIUM:
			weight = 7;
		case SMALL:
			weight = 5;
		default:
			weight = 5;
		}
	}

	@Override
	public void changeScale(int weight) {
		// TODO Auto-generated method stub
		this.weight = weight;
	}

}
