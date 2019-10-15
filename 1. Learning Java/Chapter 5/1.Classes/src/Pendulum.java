public class Pendulum implements Runnable {
	public static final float ACCELERATION_OF_GRAVITY = 9.80665f; // cannot be changed because of keyword final

	// private variables cannot be accessed from outside class
	// make a getter instead
	private float mass;
	private float length;
	private int cycles;
	private PendulumType type;

	enum PendulumType {
		SIMPLE, ONE_SPRING, TWO_SPRING
	};

	Thread t;

	public Pendulum(float length, float mass, PendulumType type) {
		// object that using "this" will refer to own variable
		this.length = length;
		this.mass = mass;
		this.type = type;

		t = new Thread(this);
		t.start();
	}

	public float getMass() {
		return this.mass;
	}

	public float getWeight() {
		return mass * ACCELERATION_OF_GRAVITY;
	}

	public float getLength() {
		return this.length;
	}

	public double getPeriode() {
		double multiplication;
		switch (this.type) {
		case ONE_SPRING:
			multiplication = 1.1;
			break;
		case TWO_SPRING:
			multiplication = 1.5;
			break;
		case SIMPLE:
			multiplication = 1.0;
			break;
		default:
			multiplication = 1.0;
		}
		return 2 * Math.PI * Math.sqrt(length / ACCELERATION_OF_GRAVITY) * multiplication;
	}

	// completed percentage
	public float getPosition(double d) {
		return (float) (d % getPeriode() / getPeriode());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				long sleepTime = (long) (getPeriode() * 1000); // convert to ms
				System.out.println("Sleep For " + String.valueOf(sleepTime));
				Thread.sleep(sleepTime);
				cycles = cycles + 1;
				System.out.println("Current Cycles : " + String.valueOf(cycles));

				if (cycles > 2) {
					resetEverything();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}
	}

	synchronized public void resetEverything() {
		t.interrupt();
		t = new Thread(this);
		t.start();
		cycles = 0;
	}

	synchronized public int getCycles() {
		return this.cycles;
	}
}