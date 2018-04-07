package com.sproggo.sproggo;

public class Player {
    private String username;
    private String password;
    private String email;

    public int score;
    public int numPhotosTaken;

    // constructor
    public Player(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

        // score and photos taken begins at zero
        score = 0;
        numPhotosTaken = 0;
    }

    // username getter
    public String getUsername() {
        return username;
    }

    // password getter
    public String getPassword() {
        return password;
    }

    // email getter
    public String getEmail() {
        return email;
    }
}
