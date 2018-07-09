package com.lavelino.registration.microservices.balancer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Luis Avelino
 */
@Controller
public class BalancerHomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}

}
