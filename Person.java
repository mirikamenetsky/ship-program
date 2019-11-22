package program10;

import java.time.*;

public class Person {

	private String firstName;
	private String lastName;
	private Gender gender;
	private LocalDate birthdate;
	private Address address;

	// create constructors
	public Person(String f, String l, Gender g, Address add) {
		this(f, l, g, add, null);
	}

	public Person(String f, String l, Gender g, String s, String c, String state, String zip, String birthdate) {
		this(f, l, g, new Address(s, c, state, zip), LocalDate.parse(birthdate));

	}

	public Person(String f, String l, Gender g, Address add, LocalDate birthdate) {
		firstName = f;
		lastName = l;
		gender = g;
		address = add;
		this.birthdate = birthdate;
	}

	public Person(Person p) {
		this(p.getFirstName(), p.getLastName(), p.getGender(), p.getAddress(), p.getBirthdate());
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public Address getAddress() {
		return address;
	}

	public void setLastName(String last) {
		lastName = last;
	}

	public void setAddress(Address addr) {
		address = addr;
	}

	public String toString() {
		StringBuilder display = new StringBuilder();
		display.append("Name: " + firstName + " " + lastName);
		display.append(" Gender: " + gender);
		display.append(" Birthday: " + birthdate);
		display.append(" Address: " + address);
		return display.toString();
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Person person = (Person) o;
		if (!this.firstName.equals(person.firstName))
			return false;
		if (!this.lastName.equals(person.lastName))
			return false;
		if (!this.birthdate.equals(person.birthdate))
			return false;
		return true;

	}

}
