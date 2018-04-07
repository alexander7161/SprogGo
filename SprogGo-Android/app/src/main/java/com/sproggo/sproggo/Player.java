package com.sproggo.sproggo;

public class Player {
    public int score;
    public int numPhotosTaken;
    public String username;
    public String password;
    public String email;

    // class constructor initialises score and photos taken to zero
    public Player(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        score = 0;
        numPhotosTaken = 0;
    }
}
