// Java program to demonstrate 
// the methods of Phaser class 

import java.util.concurrent.Phaser;

// Extend MyPhaser and override onAdvance() 
// so that only specific number of phases 
// are executed 
class MyPhaser extends Phaser {
	int numPhases;

	MyPhaser(int parties, int phaseCount) {
		super(parties);
		numPhases = phaseCount - 1;
	}

	@Override
	protected boolean onAdvance(int phase, int registeredParties) {
		System.out.println("Phase " + phase + " completed.\n");

		// If all phases have completed, return true.
		if (phase == numPhases || registeredParties == 0) {
			return true;
		}

		// otherwise, return false
		return false;
	}
}