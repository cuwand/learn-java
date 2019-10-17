
public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
	public EmployeeBuilder worksAs(String position) {
		person.position = position;
		return this;
	}

	protected EmployeeBuilder self() {
		return this;
	}
}
