/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavelino.registration.microservices.client;

import com.lavelino.registration.microservices.entity.OpenWeather;
import com.lavelino.registration.microservices.service.Playlist;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Luis Avelino
 */
@Service
public class SpotifyClient {
    
    static final Logger log = Logger.getLogger(SpotifyClient.class.getName());
    public static final String URL_SPOTIFY = "https://samples.openweathermap.org";
    public static final String URL_CITY = "/data/2.5/weather?q={city}";
    public static final String APP_ID = "&appid=ab7667b6c750ecc7476c00c79c6f59ce";
    static final Double CTE_KELVIN = 273.15;
    
    String category;
    
    @Autowired
    RestTemplate restTemplate;

    @Cacheable
    @HystrixCommand(fallbackMethod = "getSpotifyPlaylistFallback")
    public Playlist getPlayList(OpenWeather openWeather) {
        double celsius = Double.valueOf(openWeather.getMain().getTemp().trim()) - CTE_KELVIN;
        
        if (celsius > 30) {
            category = "party";
        } else if (celsius > 15 && celsius < 30) {
            category = "pop";
        } else if (celsius > 10 && celsius < 15) {
            category = "rock";
        } else {
            category = "classical";
        }
        
        return new Playlist(category + " C:" + celsius + "  K: " + openWeather.getMain().getTemp());
    }
    
    @Cacheable
    public Playlist getSpotifyPlaylistFallback() {
        Playlist playlist = new Playlist("Playlist Fallback...");
        return playlist;
    }

    
}
