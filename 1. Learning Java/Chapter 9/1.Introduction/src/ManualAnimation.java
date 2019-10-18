
public class ManualAnimation implements Runnable {
	boolean animate = true;
	String name;
	
	public ManualAnimation(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(animate) {
			System.out.println("Manual Animation Drawing Frames For " + this.name);
		}
	} 

}
