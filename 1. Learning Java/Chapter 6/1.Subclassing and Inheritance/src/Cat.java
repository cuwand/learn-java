class Cat extends Mammal {

	public Cat(float weight, int heartRate, boolean longHair) {
		super(weight, heartRate);
		this.heartRate = heartRate + 2; // independent variable
		this.longHair = longHair;
		// TODO Auto-generated constructor stub
	}

	// Shadowed Variables
	Integer heartRate;

	// inherits weight and heartRate
	boolean longHair;

	// inherits eat() and breathe()
	void purr() {
		longHair = false;
	}

	public boolean isLongHair() {
		return longHair;
	}

	public int getHeartRateDetail() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

}