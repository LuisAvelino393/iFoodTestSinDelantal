/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavelino.registration.microservices.entity;

/**
 *
 * @author Luis Avelino
 */
public class Coordinates {

    private String lon;
    private String lat;
    
    public Coordinates() {
    }

    public Coordinates(String lon, String lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
    
}
