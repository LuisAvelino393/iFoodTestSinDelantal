package com.lavelino.registration.microservices.service;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Luis Avelino
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com")
public class ServiceServer {

    public static void main(String[] args) {
        Logger log = Logger.getLogger(ServiceServer.class.getName());
        SpringApplication.run(ServiceServer.class, args);
        log.info("Service se está ejecutando...");
    }
    
}
