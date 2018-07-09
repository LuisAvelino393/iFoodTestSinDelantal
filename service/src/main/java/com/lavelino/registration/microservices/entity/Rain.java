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
public class Rain {
    private String h3;

    public Rain() {
    }

    public Rain(String h3) {
        this.h3 = h3;
    }

    public String getH3() {
        return h3;
    }

    public void setH3(String h3) {
        this.h3 = h3;
    }
    
}
