class Mammal extends Animal {
	public Mammal(float weight, int heartRate) {
		super(weight);
		this.heartRate = heartRate;
		// TODO Auto-generated constructor stub
	}

	// inherits weight
	protected int heartRate;

	public int getHeartRate() {
		System.out.println("Getting Heart Rate From Mammal");
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	void breathe() {
		this.heartRate += 1;
		this.weight -= 0.1f;
	}
}