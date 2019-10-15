
class OverridenCat extends Mammal {

	public OverridenCat(float weight, int heartRate, boolean longHair) {
		super(weight, heartRate);
		this.heartRate = heartRate + 1.5f; // independent variable
		this.longHair = false;
		this.longHair = longHair;
		// TODO Auto-generated constructor stub
	}

	// Shadowed Variables
	float heartRate;

	// inherits weight and heartRate
	boolean longHair;

	// inherits eat() and breathe()
	void purr() {
		longHair = false;
	}

	public boolean isLongHair() {
		return longHair;
	}
	
	@Override public int getHeartRate() {
		System.out.println("Getting Heart Rate From OverridenCat");
		return (int) heartRate;
	}

	public float getHeartRateDetail() {
		return this.heartRate;
	}

	public void setHeartRate(float heartRate) {
		this.heartRate = heartRate;
	}

}