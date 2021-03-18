package core.exceptions;

public class CustomException extends Exception{
	/**
	 * Custom Exception to throw customized exception message
	 * @param exceptionMessage
	 */
	public CustomException(String exceptionMessage) {
		super(exceptionMessage);
	} 

}
