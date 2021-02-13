package org.djohnson.bootme.pong.webclient;

import org.djohnson.bootme.pong.model.JwtResponse;
import org.djohnson.bootme.pong.model.LoginDTO;
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
	 * @param url the ping service's url, needs to be injected in the constructor
	 */
	public PingServiceClient(WebClient.Builder webClientBuilder, @Value("${service.ping.url}") String url) {
		
		logger.debug("creating a ping service client");
		logger.debug("base ping url {}", url);
		
		this.webClient = webClientBuilder
				.baseUrl(url)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	/**
	 * Make a call to the ping service and return the message. An example of a WebClient GET.
	 * 
	 * @return string message from ping service api
	 */
	public String callPingService() {
		
		logger.debug("calling the ping api");
		logger.debug("api ping {}", pingApiPing);
		
		Mono<String> result = webClient.get()
				.uri(pingApiPing)
				.retrieve()
				.bodyToMono(String.class);
		
		return result.block();
	}
	
	/**
	 * Make a call to the ping service and return the token. An example of a WebClient POST.
	 * 
	 * @param user		the user's name to authenticate
	 * @param secret	the user's secrete to authenticate
	 * @return	the JWT string
	 */
	public String callAuthenticationService(String user, String secret) {
		
		logger.debug("calling the ping api to authenticate");
		logger.debug("api autheticte {}", pingApiAuthenticate);
		
		LoginDTO login = new LoginDTO(user, secret);
		
		/*
		 * Note: JwtResponse is very similar to the one in the Ping service with
		 * a couple critical differences. The one in this project MUST have the default
		 * constructor and getter/setter methods for this POST/mapping to work.
		 */
		
		Mono<JwtResponse> result = webClient.post()
				.uri(pingApiAuthenticate)
				.body(Mono.just(login), LoginDTO.class)
				.retrieve()
				.bodyToMono(JwtResponse.class);
		
		return result.block().getToken();
		
	}

}
