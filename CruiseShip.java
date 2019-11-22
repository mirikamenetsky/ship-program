package program10;

import java.util.*;

public class CruiseShip extends Ship {

	private int maxPass;
	private ArrayList<Passenger> passengers;

	public CruiseShip(String name, String year, int maxPass, ArrayList<Passenger> passengers) {
		super(name, year);
		if (maxPass < 0)
			throw new IllegalArgumentException("Invalid Data");
		this.maxPass = maxPass;
		this.passengers = passengers;

	}

	public CruiseShip() {

	}

	public CruiseShip(String name, String year, int maxPass) {
		super(name, year);
		if (maxPass < 0)
			throw new IllegalArgumentException("Invalid Data");
		this.maxPass = maxPass;
		passengers = new ArrayList<Passenger>();
	}

	public CruiseShip(int maxPass, ArrayList<Passenger> passengers) {
		this(null, null, maxPass, passengers);
	}

	public CruiseShip(String name, String year, ArrayList<Passenger> passengers) {
		this(name, year, 0, passengers);
	}

	public void setmaxPass(int maxPass) {
		if (maxPass < 0)
			throw new IllegalArgumentException("Invalid Data");
		this.maxPass = maxPass;
	}

	public int getMaxPass() {
		return maxPass;
	}

	public ArrayList<Passenger> getPassengers() {
		ArrayList<Passenger> pass = new ArrayList<Passenger>();
		for (int i = 0; i < passengers.size(); i++)
			pass.set(i, passengers.get(i));
		return pass;
	}

	public void addPassengers(Passenger passenger) {
		for (int i = 0; i < passengers.size(); i++) {
			if (passengers.get(i).equals(passenger))
				throw new PassengerExistsException("Passenger Exists");
		}
		passengers.add(new Passenger(passenger));
	}

	@Override
	public String toString() {
		StringBuilder display = new StringBuilder(super.toString());
		display.append(" Maximum passengers:" + maxPass);
		display.append("\n");
		display.append("The current passengers are:");
		for (int i = 0; i < passengers.size(); i++) {
			display.append("\n");
			display.append(passengers.get(i).getFirstName() + " " + passengers.get(i).getLastName());
		}
		return display.toString();
	}
}
