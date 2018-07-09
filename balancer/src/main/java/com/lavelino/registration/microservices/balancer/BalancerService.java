package com.lavelino.registration.microservices.balancer;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


/**
 * @author Luis Avelinio
 */
@Service
public class BalancerService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected Playlist greeting;
	protected String serviceUrl;
	protected Logger logger = Logger.getLogger(BalancerService.class.getName());

	public BalancerService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	@PostConstruct
	public void demoOnly() {
		logger.warning("The RestTemplate request factory is " + restTemplate.getRequestFactory());
	}
	
	@HystrixCommand(fallbackMethod = "weatherDefault")
	public Playlist getPlaylist(String city) {
		logger.info(String.format("getPlaylist() [%s]", city));
		return restTemplate.getForObject("http://localhost:8081/suggest/playlist/city/{city}", Playlist.class, city);
	}
	
	public Playlist weatherDefault(String city) {
		return new Playlist("Circuit Breaker");
	}

}
