package org.djohnson.bootme.pong.exception;

/**
 * Custom exception for the Pong web service.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class PongException extends RuntimeException {

	private static final long serialVersionUID = -193036058213167716L;

	/**
	 * Create a new instance of PongException.
	 * 
	 * @param message	the message for the exception
	 * @param ex		the exception
	 */
	public PongException(String message, Throwable ex) {
		super(message, ex);
		
	}
	
}
