class SpreadSheet {
	int cellA1, cellA2, cellA3;

	// theese method cannot run together , because it lock the instance
	synchronized int sumRow() {
		// Reentrant locking

		// The locks acquired by Java upon entering a synchronized method or block of
		// code are reentrant, meaning that the thread holding onto the lock may acquire
		// the same lock again any number of times and never blocks waiting for itself.
		// In most cases, this means that the code behaves as you’d expect; a thread can
		// call a synchronized method recursively and can itself call upon other
		// synchronized methods within the same object.

		complexTask();
		return cellA1 + cellA2 + cellA3;
	}

	synchronized void setRow(int a1, int a2, int a3) {
		cellA1 = a1;
		cellA2 = a2;
		cellA3 = a3;
	}

	synchronized void complexTask() {
		return;
	}

	//
}