
public class Main {
	public static void main(String[] args) {
		EmployeeBuilder eb = new EmployeeBuilder();
		
		Person adrian = eb.withName("Adrian").worksAs("Developer").build();
	
		System.out.println(adrian);
	}
}
