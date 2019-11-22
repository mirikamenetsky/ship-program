package program10;

public class Address {

	private String street;
	private String city;
	private USState State;
	private String zipcode;

	public Address(String street, String city, String state, String zip) {
		this(street, city, USState.valueOf(state), zip);
	}

	public Address(String street, String city, USState state, String zip) {
		this.street = street;
		this.city = city;
		this.State = state;
		zipcode = zip;

	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public USState getState() {
		return State;
	}

	public String getZip() {
		return zipcode;
	}

	public String toString() {
		StringBuilder display = new StringBuilder();
		display.append("Address: " + street + "\n" + city + ", " + State + " " + zipcode);
		;
		return display.toString();
	}
}
