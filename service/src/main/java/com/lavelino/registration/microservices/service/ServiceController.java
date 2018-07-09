package com.lavelino.registration.microservices.service;

import com.lavelino.registration.microservices.client.SpotifyClient;
import com.lavelino.registration.microservices.entity.OpenWeather;
import com.lavelino.registration.microservices.client.WeatherClient;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luis Avelino
 */
@RestController
public class ServiceController {

    static final Logger log = Logger.getLogger(ServiceController.class.getName());

    @Autowired
    WeatherClient weatherClient;
    
    @Autowired
    SpotifyClient spotifyClient;
    
    OpenWeather openWeather;
    Playlist playlist;

    @RequestMapping("/suggest/playlist/city/{city}")
    public Playlist greeting(@PathVariable("city") String city) {
        openWeather = null;
        
        log.info(String.format("Buscando clima para la ciudad: [%s]", city));
        openWeather = weatherClient.getWeather(city);
        log.info("Se ha obtenido información del clima.");
        log.info(String.format("La ciudad [%s] tiene [%s]°K.", city, openWeather.getMain().getTemp()));
        
        log.info("Se buscará Playlist");
        playlist = spotifyClient.getPlayList(openWeather);
        log.info("Se han obtenido Playlist.");
        
        return playlist;
        
    }

}
