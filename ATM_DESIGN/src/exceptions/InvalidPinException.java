package exceptions;

public class InvalidPinException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7739049293300506757L;
	
	public InvalidPinException(String msg) {
		super(msg);
	}

}
