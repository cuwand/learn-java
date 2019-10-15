//fully abstract class
interface Driveable {
	boolean startEngine();

	void stopEngine();

	float accelerate(float acc);

	boolean turn(Direction dir);
}