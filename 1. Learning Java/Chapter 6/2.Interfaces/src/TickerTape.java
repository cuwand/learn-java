class TickerTape implements TextReceiver {
	public void receiveText(String text) {
		System.out.println("TICKER : " + text);
	}
}