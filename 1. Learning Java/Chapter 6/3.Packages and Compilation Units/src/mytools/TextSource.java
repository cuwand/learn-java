package mytools;

import mytools.text.*;

public class TextSource {
	TextReceiver receiver;

	// This interface is not visible to other package
	// InvisibleTextReceiver

	public TextSource(TextReceiver r) {
		receiver = r;
	}

	public void sendText(String s) {
		receiver.receiveText(s);
	}
}