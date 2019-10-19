
public class SpeechSynthesizer {
	String lastWord;

	public synchronized static void staticSay() {
		// lock the class instance
		// synchronized ( SpeechSynthesizer.class) {}

	}

	// The JVM will assure this methods will not running together at once

	// Because say() is an instance method, a thread must acquire the lock on the
	// SpeechSynthesizer instance (object) it’s using before it can invoke the say()
	// method.
	synchronized void say(String words) {
		// speak
	}

	void say() {
		// Exculsive lock to the variable only
		// In addition to synchronizing entire methods, the synchronized keyword can be
		// used in a special construct to guard arbitrary blocks of code. In this form,
		// it also takes an explicit argument that specifies the object for which it is
		// to acquire a lock:
		synchronized (lastWord) {
		}
	}

	void equivalentWithSay() {
		synchronized (this) {
			// speak
		}
	}
	// If say() were a class (static) method instead of an instance method, we could
	// still mark it as synchronized . In this case, because no instance object is
	// involved, the lock is on the class object itself.
}
