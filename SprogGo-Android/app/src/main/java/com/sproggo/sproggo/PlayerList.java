package com.sproggo.sproggo;

import android.widget.EditText;
import java.util.ArrayList;

public class PlayerList {
    // creates an array to store every player in
    private ArrayList<Player> playerList = new ArrayList<>();

    // adds a player
    public void createAccount(EditText username, EditText password, EditText email) {
        playerList.add(new Player(username, password, email));
    }

    // logs in
    public boolean login(EditText username, EditText password) {
        // iterates through each player and checks the username and password match
        for (Player player : playerList) {
            if (player.getUsername().equals(username) && player.getPassword().equals(password)) {
                // returns true if they match
                return true;
            }
        }
        // false otherwise
        return false;
    }
}
