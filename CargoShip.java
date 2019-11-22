package program10;

public class CargoShip extends Ship {

	private int maxCargo;

	// create no arg constructor
	public CargoShip() {

	}

	// create an args constructor
	public CargoShip(String name, String year, int maxCargo) {
		super(name, year);
		if (maxCargo < 0)
			throw new IllegalArgumentException("Invalid Data");
		this.maxCargo = maxCargo;
	}

	public CargoShip(String name, String year) {
		this(name, year, 0);
	}

	public void setMaxCargo(int maxCargo) {

		if (maxCargo < 0)
			throw new IllegalArgumentException("Invalid Data");
		this.maxCargo = maxCargo;
	}

	public int getMaxCargo() {
		return maxCargo;
	}

	@Override
	public String toString() {
		StringBuilder display = new StringBuilder();
		display.append("Name: " + getName());
		display.append(" Cargo Capacity: " + maxCargo);
		return display.toString();
	}

}
