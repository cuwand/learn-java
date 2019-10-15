class Box implements Scaleable {
	float weight;

	public Box(int size) {
		setScale(size);
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
}