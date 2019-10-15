package main;

import mytools.*;
import static java.lang.Math.*; //Importing its static variable and its function (as usual)
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.BLUE;

public class Main {
	public static void main(String[] args) {
		TextSource ts = new TextSource(new TickerTape());
		ts.sendText("OKE");

		System.out.println(Math.abs(-100));

		double circumference = 2 * PI;
		System.out.println(circumference);
		System.out.println(BLUE);
		System.out.println(WHITE);
		System.out.println(RED);

		System.out.println("Done");
	}
}
