package com.lavelino.registration.microservices.service;

import java.io.Serializable;

public class Playlist implements Serializable {
    private static final long serialVersionUID = 1L;
	
    private final String content;

    public Playlist(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
