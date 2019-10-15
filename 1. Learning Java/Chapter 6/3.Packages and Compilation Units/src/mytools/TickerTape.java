package mytools;

import mytools.text.TextReceiver;

public class TickerTape implements TextReceiver {
	public void receiveText(String text) {
		System.out.println("TICKER : " + text);
	}
}