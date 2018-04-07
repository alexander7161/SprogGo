package com.sproggo.sproggo;

import android.widget.EditText;

public class Player {
    private EditText username;
    private EditText password;
    private EditText email;

    public int score;
    public int numPhotosTaken;

    // constructor
    public Player(EditText username, EditText password, EditText email) {
        this.username = username;
        this.password = password;
        this.email = email;

        // score and photos taken begins at zero
        score = 0;
        numPhotosTaken = 0;
    }

    // username getter
    public EditText getUsername() {
        return username;
    }

    // password getter
    public EditText getPassword() {
        return password;
    }

    // email getter
    public EditText getEmail() {
        return email;
    }
}
