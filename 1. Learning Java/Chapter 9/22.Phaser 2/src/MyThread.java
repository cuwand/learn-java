// Java program to show Phaser Class 

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Phaser;

// A thread of execution that uses a phaser. 
class MyThread implements Runnable {
	Phaser phaser;
	String title;

	public MyThread(Phaser phaser, String title) {
		this.phaser = phaser;
		this.title = title;

		phaser.register();
		new Thread(this).start();
	}

	private static Integer randomMath() {
		double randomDouble = Math.random();
		randomDouble = randomDouble * 10 + 1;
		int randomInt = (int) randomDouble;
		return randomInt;
	}

	private void printTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(title + " >> " + sdf.format(cal.getTime()));

	}

	@Override
	public void run() {
		int sleepPhaseZero = randomMath();
		printTime();
		System.out.println("Thread: " + title + " of Phase Zero Started , sleep " + sleepPhaseZero);
		try {
			Thread.sleep(sleepPhaseZero * 1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		System.out.println("Thread " + title + " Phase Zero Arrived");
		phaser.arriveAndAwaitAdvance();
		// Stop execution to prevent jumbled output

		printTime();
		int sleepPhaseOne = randomMath();
		System.out.println("Thread: " + title + " of Phase One Started, sleep " + sleepPhaseOne);

		// Stop execution to prevent jumbled output
		try {
			Thread.sleep(sleepPhaseOne * 1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		System.out.println("Thread " + title + " Phase One Arrived");
		phaser.arriveAndAwaitAdvance();

		printTime();
		int sleepPhaseTwo = randomMath();
		System.out.println("Thread: " + title + " of Phase Two Started, sleep " + sleepPhaseTwo);

		// Stop execution to prevent jumbled output
		try {
			Thread.sleep(sleepPhaseTwo * 1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		System.out.println("Thread " + title + " Phase Two arriveAndDeregister");
		phaser.arriveAndDeregister();
		int total = sleepPhaseZero + sleepPhaseOne + sleepPhaseTwo;
		System.out.println("Total Sleep (" + title + ") : " + total);

		printTime();
		System.out.println("-------------------" + title + "--------------------");
	}
}
