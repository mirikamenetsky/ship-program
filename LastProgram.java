package program10;

import java.util.*;

public class LastProgram {

	// create a program that gathers information for two arraylists, of
	// cargo ships and cruise ships

	public static void main(String[] args) {

		// create a Scanner object to receive the users input
		Scanner keyboard = new Scanner(System.in);

		// create an arrayList of cruise ships
		ArrayList<CruiseShip> cruise = new ArrayList<>();

		// create an arrayList of cargo ships
		ArrayList<CargoShip> cargo = new ArrayList<>();

		int numOfCruise;
		do {
			// ask the user how many Cruise Ships there are
			System.out.println("How many Cruise Ships are there? Make sure you enter a postive number");
			numOfCruise = keyboard.nextInt();
		} while (numOfCruise < 0);
		// flush the buffer
		keyboard.nextLine();

		// send to cruise method
		cruise(keyboard, numOfCruise, cruise);

		int numOfCargo;
		do {
			// ask the user how many Cargo Ships there are
			System.out.println("How many Cargo Ships are there? Make sure you enter a positive number");
			numOfCargo = keyboard.nextInt();
			// flush the buffer
			keyboard.nextLine();
		} while (numOfCargo < 0);

		// send to cargo method
		cargo(keyboard, numOfCargo, cargo);
		display(cruise, cargo);

	}

	public static void cruise(Scanner keyboard, int numOfCruise, ArrayList<CruiseShip> cruise) {
		try {
			for (int i = 0; i < numOfCruise; i++) {
				System.out.println("CRUISE SHIP #" + (i + 1));
				System.out.println("_________________");
				System.out.println("Name:");
				String nameCruise = keyboard.nextLine();
				System.out.println("Year built:");
				String yearCruise = keyboard.nextLine();
				System.out.println("Maximum number of passengers:");
				int maxPass = keyboard.nextInt();
				// clear the buffer
				keyboard.nextLine();
				cruise.add(new CruiseShip(nameCruise, yearCruise, maxPass));
				pass(i, keyboard, maxPass, cruise);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void pass(int i, Scanner keyboard, int maxPass, ArrayList<CruiseShip> cruise) {
		try {
			System.out.println("Number of passengers:");
			int numPass = keyboard.nextInt();
			// flush the buffer
			keyboard.nextLine();
			for (int j = 0; j < numPass; j++) {
				System.out.println("Enter the information for passenger #" + (j + 1));
				System.out.println("First name:");
				String name = keyboard.nextLine();
				System.out.println("Last name:");
				String lastName = keyboard.nextLine();
				System.out.println("Gender, m for male or f for female?");
				String input = keyboard.nextLine().toUpperCase();
				Gender gender = Gender.valueOf(input.toUpperCase());
				System.out.print("Birthdate yyyy-mm-dd: ");
				String birthday = keyboard.nextLine();
				System.out.println("Passenger's address street name:");
				String street = keyboard.nextLine();
				System.out.println("City:");
				String city = keyboard.nextLine();
				System.out.println("State:");
				String state = keyboard.nextLine().toUpperCase();
				int position = state.indexOf(" ");
				if (position >= 0)
					state = state.substring(0, position) + state.substring(position + 1);
				USState st = USState.valueOf(state);
				System.out.println("Zip code:");
				String zip = keyboard.nextLine();
				System.out.println("Passport ID:");
				int passID = keyboard.nextInt();
				System.out.println("Number of luggage pieces:");
				int pieces = keyboard.nextInt();
				keyboard.nextLine();
				cruise.get(i).addPassengers(new Passenger(name, lastName, gender, new Address(street, city, st, zip),
						birthday, passID, pieces));
				System.out.println();
			}
		} catch (PassengerExistsException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void cargo(Scanner keyboard, int numOfCargo, ArrayList<CargoShip> cargo) {
		try {
			for (int i = 0; i < numOfCargo; i++) {
				System.out.println("CARGO SHIP #" + (i + 1));
				System.out.println("________________");
				System.out.print("Name:");
				String name = keyboard.nextLine();
				System.out.print("Year built:");
				String year = keyboard.nextLine();
				System.out.print("Maximum Cargo Capacity(tonage):");
				int maxCargo = keyboard.nextInt();
				keyboard.nextLine();
				cargo.add(new CargoShip(name, year, maxCargo));
				System.out.println();
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void display(ArrayList<CruiseShip> cruise, ArrayList<CargoShip> cargo) {
		System.out.println("Cruise Ships:");
		for (CruiseShip temp : cruise)
			System.out.println(temp);
		System.out.println();
		System.out.println("Cargo Ships:");
		for (CargoShip temp : cargo)
			System.out.println(temp);
	}
}
