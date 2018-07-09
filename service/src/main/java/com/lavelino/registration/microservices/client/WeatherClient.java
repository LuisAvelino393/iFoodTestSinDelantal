/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavelino.registration.microservices.client;

import com.lavelino.registration.microservices.entity.Main;
import com.lavelino.registration.microservices.entity.OpenWeather;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Luis Avelino
 */
@Service
public class WeatherClient {
    
    static final Logger log = Logger.getLogger(WeatherClient.class.getName());
    public static final String URL_WEATHER = "https://samples.openweathermap.org";
    public static final String URL_CITY = "/data/2.5/weather?q={city}";
    public static final String APP_ID = "&appid=ab7667b6c750ecc7476c00c79c6f59ce";   
    
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getWeatherFallback")
    public OpenWeather getWeather(String city) {
        OpenWeather openWeather = null;
        log.info(String.format("Llamando a openweathermap para la ciudad [%s]", city));
        RestTemplate rt = new RestTemplate();
        openWeather = rt.getForObject(URL_WEATHER + URL_CITY + APP_ID, OpenWeather.class, city);
        log.info(String.format("Ha concluido la llamada a openweathermap. Cod[%s]", openWeather.getCod()));
        return openWeather;
    }

    public OpenWeather getWeatherFallback(String city) {
        log.info(String.format("getWeatherFallback: [%s]", city));
        OpenWeather openWeather = new OpenWeather();
        //SETTEAR LOS DATOS NECESARIOS A openWeather
        Main main = new Main();
        main.setTemp("297.15"); //24°C default
        openWeather.setMain(main);
        openWeather.setCod("200");
        return openWeather;
    }
    
    
}
