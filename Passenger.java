package program10;

import java.time.*;

public class Passenger extends Person {

	private int passportID;
	private int luggagePieces;

	public Passenger(String f, String l, Gender g, Address addr, String birthdate, int passportID, int luggage) {
		super(f, l, g, addr, LocalDate.parse(birthdate));
		if (passportID < 0 || luggage < 0)
			throw new IllegalArgumentException("Invalid Data");
		this.passportID = passportID;
		luggagePieces = luggage;

	}

	public Passenger(Passenger p) {
		this(p.getFirstName(), p.getLastName(), p.getGender(), p.getAddress(), String.valueOf(p.getBirthdate()),
				p.passportID, p.luggagePieces);
	}

	@Override
	public String toString() {
		StringBuilder display = new StringBuilder(super.toString());
		display.append("Passport ID:" + passportID);
		display.append(" Luggage Pieces: " + luggagePieces);
		return display.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Passenger object = (Passenger) o;
		if (object.passportID != this.passportID)
			return false;
		return true;
	}
}
