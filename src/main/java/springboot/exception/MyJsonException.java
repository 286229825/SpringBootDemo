package springboot.exception;

public class MyJsonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6734749239130170666L;

	public MyJsonException(String message) {
		super(message);
	}
}
