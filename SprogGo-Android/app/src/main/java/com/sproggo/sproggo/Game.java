package com.sproggo.sproggo;

import java.util.ArrayList;

public class Game {
    private String[] wordsToTest;
    private int numOfWords;
    private Player player;

    public Game(String[] wordsToTest, int numOfWords, Player player) {
        this.wordsToTest = wordsToTest;
        this.numOfWords = numOfWords;
        this.player = player;
    }
}
