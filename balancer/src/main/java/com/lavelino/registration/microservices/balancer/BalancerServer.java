package com.lavelino.registration.microservices.balancer;


import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @author Luis Avelino
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RibbonClient (name = "suggest-spotify-playlist-balancer", configuration = BalancerServer.class)
@ComponentScan(useDefaultFilters = false)
public class BalancerServer {

	public static final String SERVICE_URL = "http://suggest-spotify-playlist-service";

	public static void main(String[] args) {
                Logger log = Logger.getLogger(BalancerServer.class.getName());
		SpringApplication.run(BalancerServer.class, args);
                log.info("Balancer se está ejecutando...");
	}
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public BalancerService helloWorldService() {
		return new BalancerService(SERVICE_URL);
	}

	@Bean
	public BalancerController helloWorldController() {
		return new BalancerController(helloWorldService());
	}

	@Bean
	public BalancerHomeController homeController() {
		return new BalancerHomeController();
	}
}
