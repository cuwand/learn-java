
public class Address {
	String street, city;
	int building;

	public Address(String street, String city, int building) {
		super();
		this.street = street;
		this.city = city;
		this.building = building;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [street=");
		builder.append(street);
		builder.append(", city=");
		builder.append(city);
		builder.append(", building=");
		builder.append(building);
		builder.append("]");
		return builder.toString();
	}
}
