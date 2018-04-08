package com.sproggo.sproggo;

import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerList {
    // creates an array to store every player in
    private static ArrayList<Player> playerList = new ArrayList<>();

    // adds a player
    public static void createAccount(String username, String password, String email) {
        playerList.add(new Player(username, password, email));
    }

    // logs in
    public static boolean login(String username, String password) {
        createAccount("TextView", "TextView", "TextView");
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

    public static Player getUser(String user) {
        for (Player player : playerList) {
            if (player.getUsername().equals(user)) {
                return player;
            }
        }
        return null;
    }
}
