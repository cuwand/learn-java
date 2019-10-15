import java.awt.Color;
import java.util.Hashtable;
import java.util.Properties;

public class Pendulum implements Runnable {
	// Static variable can be accessed without initializing Object
	public static final float ACCELERATION_OF_GRAVITY = 9.80665f; // cannot be changed because of keyword final
	static final float DEFAULT_BALL_MASS = 1.0f;
	static final PendulumType DEFAULT_PENDULUM_TYPE = PendulumType.SIMPLE;
	// private variables cannot be accessed from outside class
	// make a getter instead
	private Ball ball;
	private float length;
	private int cycles;
	private PendulumType type;
	private Properties myProps = new Properties();

	// This code block doesn’t belong to any method; instead, it’s executed once, at
	// the time the object is constructed, or, in the case of a code block marked
	// static , at the time the class is loaded. These blocks can be used to do
	// additional setup for the class or an object instance and are called
	// initializer blocks

	// set up myProps
	{
		myProps.put("foo", "bar");
		myProps.put("boo", "gee");
	}

	static Hashtable<String, Color> colors = new Hashtable<String, Color>();
	
	//set up colors
	static {
		colors.put("Red", Color.red);
		colors.put("Green", Color.green);
		colors.put("Blue", Color.blue);
	}

	enum PendulumType {
		SIMPLE, ONE_SPRING, TWO_SPRING
	};

	Thread t;

	// Static Methods can be accessed without initializing object
	public static PendulumType[] getAvailablePendulumType() {
		return PendulumType.values();
	}

	public Pendulum(float length, Ball ball, PendulumType type) {
		// object that using "this" will refer to own variable
		this.length = length;
		this.ball = ball;
		this.type = type;

		t = new Thread(this);
		t.start();
	}

	// Error: constructor call must be first statement
	// public Pendulum(float length) {
	// __Ball ball = new Ball(DEFAULT_BALL_MASS);
	// __this(m, ball, DEFAULT_PENDULUM_TYPE); <-- constructor call
	// }

	// Overloaded Constructor
	public Pendulum(float length) {
		this(length, new Ball(DEFAULT_BALL_MASS), DEFAULT_PENDULUM_TYPE);
	}

	public float getMass() {
		return this.ball.getMass();
	}

	public float getWeight() {
		return getMass() * ACCELERATION_OF_GRAVITY;
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
				// e.printStackTrace();
				System.out.println("Pendulum Stop Swinging");
				return;
			}
		}
	}

	public void stopSwing() {
		t.interrupt();
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