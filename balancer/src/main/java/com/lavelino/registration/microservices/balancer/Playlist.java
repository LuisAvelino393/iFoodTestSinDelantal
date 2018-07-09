package com.lavelino.registration.microservices.balancer;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("playlist")
public class Playlist {
    protected String content;

    public Playlist(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
