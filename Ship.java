package program10;

public class Ship {

	private String name;
	private String year;

	// create a no args constructor
	public Ship() {

	}

	// create arg constructors
	public Ship(String name, String year) {
		this.name = name;
		this.year = year;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public String getYear() {
		return year;
	}

	@Override
	public String toString() {
		StringBuilder display = new StringBuilder();
		display.append("Ship Name: " + name);
		display.append(" Year built: " + year);
		return display.toString();
	}
}
