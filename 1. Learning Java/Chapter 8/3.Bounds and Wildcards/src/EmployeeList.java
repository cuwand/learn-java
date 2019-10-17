import java.util.*;

import com.sun.tools.sjavac.server.SysInfo;

class EmployeeList<T extends Employee & Ranked & Printable> {
	Ranked ranking;
	List<Printable> printList = new ArrayList<Printable>();

	public void addEmployee(T employee) {
		this.ranking = employee; // T as Ranked
		printList.add(employee); // T as Printable
	}

	public Ranked getRanking() {
		return ranking;
	}

	public void setRanking(Ranked ranking) {
		this.ranking = ranking;
	}

	public List<Printable> getPrintList() {
		return printList;
	}

	public void setPrintList(List<Printable> printList) {
		this.printList = printList;
	}

}