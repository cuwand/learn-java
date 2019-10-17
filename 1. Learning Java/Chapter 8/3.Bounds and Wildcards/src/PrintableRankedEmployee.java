
public class PrintableRankedEmployee extends Employee implements Printable, Ranked {
	int rank;

	public PrintableRankedEmployee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setRank(int rank) {
		System.out.println("Employee " + this.name + " rank : " + rank);
		// TODO Auto-generated method stub
		this.rank = rank;
	}

	@Override
	public int getRank() {
		// TODO Auto-generated method stub
		return rank;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("My Name is " + this.name);
	}

}
