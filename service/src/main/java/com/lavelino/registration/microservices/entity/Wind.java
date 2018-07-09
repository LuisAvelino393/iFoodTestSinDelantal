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
public class Wind {
    private String speed;
    private String deg;

    public Wind() {
    }

    public Wind(String speed, String deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
    
}
