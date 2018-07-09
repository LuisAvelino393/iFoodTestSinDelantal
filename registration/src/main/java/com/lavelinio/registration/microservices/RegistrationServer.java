package com.lavelinio.registration.microservices;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Luis Avelino
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationServer {

    public static void main(String[] args) {
        Logger log = Logger.getLogger(RegistrationServer.class);
        SpringApplication.run(RegistrationServer.class, args);
        log.info("Registry service se está ejecutando...");
    }
    
}
