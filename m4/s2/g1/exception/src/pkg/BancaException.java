package pkg;

public class BancaException extends Exception {
	public BancaException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return getMessage();
	}
}
