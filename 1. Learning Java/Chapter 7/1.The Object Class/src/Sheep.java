import java.util.HashMap;

// Invoking Object's clone method on an instance
// that does not implement the Cloneable interface
// results in the exception 
// CloneNotSupportedException being thrown.

public class Sheep implements Cloneable {
	HashMap flock = new HashMap();

	public HashMap getFlock() {
		return flock;
	}

	public Sheep clone() {
		try {
			return (Sheep) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error("This should never happen because we implement Cloneable!");
		}
	}
}