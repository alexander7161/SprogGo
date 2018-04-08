package com.sproggo.sproggo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {
    private static Random randomGenerator;
    private static List<String> wordsToTest;
    private static int numOfWordsToTest;
     private static List<String> hackathon = Arrays.asList("laptop", "phone", "water", "chair", "table", "fruit");
    private static List<String> animal = Arrays.asList("dog", "cat", "pig", "sheep", "cow", "horse", "spider", "hippopotamus", "elephant");
    private static List<String> garden = Arrays.asList("flower", "tree", "grass");

    private Game() {
    }

    public static void setUpGame(String categoryName, int numOfWords) {

        switch(categoryName) {
            case "hackathon":
                wordsToTest = hackathon;
                break;
            case "animal":
                wordsToTest = animal;
                break;
            case "garden":
                wordsToTest = garden;
                break;
        }
        randomGenerator = new Random();
        numOfWordsToTest = numOfWords;
    }

    public static String nextWord() {
        if(numOfWordsToTest == 0) {
            return null;
        } else {
            numOfWordsToTest--;
            return wordsToTest.get(randomGenerator.nextInt(wordsToTest.size()));

        }
    }

}
