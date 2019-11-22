package program10;

public class PassengerExistsException extends RuntimeException {

	public PassengerExistsException() {
		super("Passenger Exists");
	}

	public PassengerExistsException(String message) {
		super(message);
	}
}
