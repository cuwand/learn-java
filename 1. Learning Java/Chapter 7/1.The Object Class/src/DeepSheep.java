import java.util.HashMap;

public class DeepSheep implements Cloneable {
	HashMap flock = new HashMap();

	public HashMap getFlock() {
		return flock;
	}

	public DeepSheep clone() {
		try {
			DeepSheep copy = (DeepSheep) super.clone();
			copy.flock = (HashMap) flock.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			throw new Error("This should never happen!");
		}
	}
}