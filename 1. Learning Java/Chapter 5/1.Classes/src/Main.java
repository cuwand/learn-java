

public class Main {
	public static void main(String[] args) {
		Pendulum p;
		p = new Pendulum(2, 2, Pendulum.PendulumType.ONE_SPRING);
		float pos = p.getPosition( 1.0 );
		
		System.out.println(pos);
		System.out.println(Pendulum.ACCELERATION_OF_GRAVITY);
		System.out.println("Done");
	}
}
