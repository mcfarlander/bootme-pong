package org.djohnson.bootme.pong.controller;

import org.djohnson.bootme.pong.exception.PongException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The centralized error handler for the controllers.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@ControllerAdvice
public class PongExceptionController {
	
	@ExceptionHandler(value = PongException.class)
	public ResponseEntity<Object> exception(PongException exception) {
	      return new ResponseEntity<>("Bootme Pong Error " + exception.getMessage(), HttpStatus.OK);
	}

}
