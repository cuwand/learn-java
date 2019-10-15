class TextSource {
	TextReceiver receiver;

	TextSource(TextReceiver r) {
		receiver = r;
	}

	public void sendText(String s) {
		receiver.receiveText(s);
	}
}