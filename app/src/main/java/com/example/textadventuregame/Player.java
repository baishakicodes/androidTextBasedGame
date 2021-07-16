package com.example.textadventuregame;

public class Player {

    private String location;

    public Player() {
        this("");
    }

    public Player(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
