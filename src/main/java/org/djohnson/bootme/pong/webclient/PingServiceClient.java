package org.djohnson.bootme.pong.webclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/**
 * A service class for making REST calls to the ping service.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@Service
public class PingServiceClient {
	
	private static final Logger logger = LoggerFactory.getLogger(PingServiceClient.class);
	
    @Value("${service.ping.url}")
    private String pingServiceUrl;

    @Value("${service.ping.ping}")
    private String pingApiPing;
    
    @Value("${service.ping.authenticate}")
    private String pingApiAuthenticate;
    
    @Value("${service.ping.validateToken}")
    private String pingApiValidateToken;
    
	private final WebClient webClient;

	/**
	 * Create a new instance of PingServiceClient.
	 * 
	 * @param webClientBuilder injected web client
	 */
	public PingServiceClient(WebClient.Builder webClientBuilder) {
		
		logger.debug("creating a ping service client");
		logger.debug("base ping url {}", pingServiceUrl);
		
		this.webClient = webClientBuilder
				.baseUrl(pingServiceUrl)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	/**
	 * Make a call to the ping service and return the message.
	 * 
	 * @return string message from ping service api
	 */
	public String callPingService() {
		
		logger.debug("calling the ping api");
		logger.debug("api ping {}", pingApiPing);
		
		Mono<String> result = webClient.get()
				.uri("pingApiPing")
				.retrieve()
				.bodyToMono(String.class);
		
		return result.block();
	}

}
