
public class Car implements Driveable {
	float acceleration;
	float speed;

	public float getSpeed() {
		return speed;
	}

	Direction currentDirection;

	public Car(float acc) {

	}

	@Override
	public boolean startEngine() {
		if (acceleration != 0) {
			speed = acceleration;
			return true;
		}
		return false;
	}

	@Override
	public void stopEngine() {
		// TODO Auto-generated method stub
		speed = 0;
	}

	@Override
	public float accelerate(float acc) {
		if (acc < this.acceleration) {
			this.speed += acceleration;
		} else {
			this.speed += acc;
		}
		return speed;
	}

	@Override
	public boolean turn(Direction dir) {
		// TODO Auto-generated method stub
		currentDirection = dir;
		return true;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

}
