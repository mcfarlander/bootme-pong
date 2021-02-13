package org.djohnson.bootme.pong.model;

import java.io.Serializable;

/**
 * The response object when a user authenticates with the service.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -2529332627156581825L;
	
	private String jwttoken;
	
	/**
	 * Create a new instance of JwtResponse.
	 */
	public JwtResponse() {
		
	}

	/**
	 * Create a new instance of JwtResponse.
	 * 
	 * @param jwttoken the string token to use 
	 */
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	/**
	 * Get the token contained within this object.
	 * 
	 * @return the string token
	 */
	public String getToken() {
		return this.jwttoken;
	}
	
	/**
	 * Set the token from another source.
	 * 
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.jwttoken = token;
	}
	
}
