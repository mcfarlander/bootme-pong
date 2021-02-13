package org.djohnson.bootme.pong.controller;

import java.util.Date;

import org.djohnson.bootme.pong.webclient.PingServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Pong Controller is the main controller for the Pong service.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@RestController
@RequestMapping("/api")
public class PongController {
	
	private static final Logger logger = LoggerFactory.getLogger(PongController.class);
	
	@Autowired
	private PingServiceClient pingServiceClient;

	/**
	 * Create a simple message from the pong service.
	 * 
	 * @return the pong date message
	 */
	@RequestMapping("/pong")
	public String getPong() {
		logger.debug("accessing pong GET controller");
		return "bootme pong " + new Date();
	}
	
	/**
	 * Call the Ping service and return the default ping service.
	 * 
	 * @return the ping date message
	 */
	@RequestMapping("/pingpong")
	public String getPingPong() {
		logger.debug("accessing ping GET controller from pong");
		return pingServiceClient.callPingService();
		
	}
	
	/**
	 * Call the Ping service and return a token.
	 * 
	 * @return the ping date message
	 */
	@RequestMapping("/pingtoken")
	public String getPingToken() {
		logger.debug("accessing ping GET controller from pong for authentication.");
		return pingServiceClient.callAuthenticationService("foo", "bar");
		
	}

}
