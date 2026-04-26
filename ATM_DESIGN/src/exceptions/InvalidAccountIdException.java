package exceptions;

public class InvalidAccountIdException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7739049293300506757L;
	
	public InvalidAccountIdException(String msg) {
		super(msg);
	}

}
