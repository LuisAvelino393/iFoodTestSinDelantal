/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavelino.registration.microservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *
 * @author Luis Avelino
 */
@JsonRootName("weather")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeather {

//    private Coordinates coord;
//    private Weather weather;
//    private String base;
    private Main main;
//    private Wind wind;
//    private Clouds clouds;
//    private Rain rain;
//    private String dt;
//    private Sys sys;
//    private String id;
//    private String name;
    private String cod;

    public OpenWeather() {
    }

    public OpenWeather(Main main, String cod) {
        this.main = main;
        this.cod = cod;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    
    

}
