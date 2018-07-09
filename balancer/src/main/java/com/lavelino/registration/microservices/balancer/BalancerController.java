package com.lavelino.registration.microservices.balancer;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Luis Avelino
 */
@Controller
public class BalancerController {

	@Autowired
	protected BalancerService balancerService;

	Logger logger = Logger.getLogger(BalancerController.class.getName());

	public BalancerController(BalancerService helloWorldService) {
		this.balancerService = helloWorldService;
	}

	@RequestMapping("/suggest/playlist/city")
	public String goHome() {
		return "index";
	}
	
	@RequestMapping("/suggest/playlist/city/{city}")
	public Playlist getPlaylist(Model model, @PathVariable("city") String city) {
		Playlist playlist = balancerService.getPlaylist(city);
		model.addAttribute("greeting", playlist.getContent());
		return playlist;
	}
	
}
