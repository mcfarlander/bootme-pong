package org.djohnson.bootme.pong.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class PongController {
	
	private static final Logger logger = LoggerFactory.getLogger(PongController.class);

	@RequestMapping("/pong")
	public String index() {
		logger.debug("accessing pong GET controller");
		System.out.println("access pong GET controller");
		return "bootme pong " + new Date();
	}

}
