import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(3);
		exec.schedule(new MyRunnable(), 2, TimeUnit.SECONDS); // run 2 second in the future
		// run at specified date and time

		Calendar futureDate = new GregorianCalendar(2019, 10, 19, 17, 59, 0); // convertfrom calendar

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		System.out.println(sdf.format(futureDate.getTime()));

		Date date = futureDate.getTime(); // to Date
		long delay = date.getTime() - System.currentTimeMillis(); // to relative
		// millis
		System.out.println("Waiting For " + delay);
		exec.schedule(new MyRunnable(), delay, TimeUnit.MILLISECONDS); // run at specified
		// date

		Runnable cleanup = new Runnable() {
			public void run() {
				// cleanUpLogFiles();
			}
		};
		long period = 12 * 60 * 60, delay1 = period; // seconds
		Future<?> logService = exec.scheduleAtFixedRate(cleanup, delay1, period, TimeUnit.SECONDS);
	}

}
