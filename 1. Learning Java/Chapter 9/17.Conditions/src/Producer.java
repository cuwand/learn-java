import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Producer extends Thread {
	private final static String FILENAME = "input.txt";
	private final SharedFiFoQueue queue;
	private final String fileName;

	public Producer(SharedFiFoQueue queue) {
		this(queue, FILENAME);
	}

	public Producer(SharedFiFoQueue queue, String fileName) {
		this.fileName = fileName;
		this.queue = queue;
	}

	@Override
	public void run() {
		BufferedReader rd = null;

		try {
			rd = new BufferedReader(new FileReader(this.fileName));

			String inputLine = null;
			while ((inputLine = rd.readLine()) != null) {
				String[] inputWords = inputLine.split(" ");

				for (String inputWord : inputWords) {
					queue.add(inputWord);
				}
			}

			// Terminate the execution.
			queue.add(null);
		} catch (InterruptedException ex) {
			System.err.println("An InterruptedException was caught: " + ex.getMessage());
			ex.printStackTrace();
		} catch (IOException ex) {
			System.err.println("An IOException was caught: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (rd != null)
					rd.close();
			} catch (IOException ex) {
				System.err.println("An IOException was caught: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
}