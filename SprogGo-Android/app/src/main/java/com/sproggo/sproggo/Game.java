package com.sproggo.sproggo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private List<String> wordsToTest;
    private int currentNumWords;
    private int numOfWords;
    private Player player;

    public Game(List<String> wordsToTest, int numOfWords, Player player) {
        this.wordsToTest = wordsToTest;
        this.numOfWords = numOfWords;
        this.player = player;
    }

    public String nextWord() {
        if(currentNumWords == 0) {
            return null;
        } else {
            currentNumWords--;
            return wordsToTest.get(0);
        }
    }
}
