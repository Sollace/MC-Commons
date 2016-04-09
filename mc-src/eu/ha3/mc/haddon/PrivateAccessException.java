package eu.ha3.mc.haddon;

@SuppressWarnings("serial")
public class PrivateAccessException extends Exception {
	public PrivateAccessException(String contents) {
		super(contents);
	}
	
	public PrivateAccessException(String message, Throwable cause) {
		super(message, cause);
	}
}
