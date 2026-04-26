package exceptions;

public class InvalidCardException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7739049293300506757L;
	
	public InvalidCardException(String msg) {
		super(msg);
	}

}
