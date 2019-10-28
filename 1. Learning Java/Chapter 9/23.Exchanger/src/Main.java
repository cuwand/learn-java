import java.util.concurrent.Exchanger;

public class Main {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();

		new UseString(exchanger);
		new MakeString(exchanger);
	}
}