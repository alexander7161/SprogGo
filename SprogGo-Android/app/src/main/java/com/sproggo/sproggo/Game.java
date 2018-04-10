package com.sproggo.sproggo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {
    private static Random randomGenerator;

    // selected by user.
    private static List<String> wordsToTest;
    private static int numOfWordsToTest;

    // Words for each category.
    private static List<String> hackathon = new LinkedList<String>(Arrays.asList("laptop", "phone", "water", "chair", "table", "fruit"));
    private static List<String> animal = new LinkedList<String>(Arrays.asList("dog", "cat", "pig", "sheep", "cow", "horse", "spider", "hippopotamus", "elephant"));
    private static List<String> garden = new LinkedList<String>(Arrays.asList("flower", "tree", "grass"));
    private static List<String> danishHackathon = new LinkedList<String>(Arrays.asList("baerbar", "telefon", "vand", "stol", "bord", "frugt"));

    // Statistics this game.
    private static int score;
    private static int photosTaken;
    private static int correctPhotosTaken;
    private static TreeMap<String, Boolean> wordsTested;

    private Game() {
    }

    public static void setUpGame(String categoryName, int numOfWords) {
        // set up new game with starting values.
        score = 0;
        photosTaken = 0;
        correctPhotosTaken = 0;
        wordsTested = new TreeMap<>();

        // Get words for chosen category.
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
            case "Danish Hackathon":
                wordsToTest = danishHackathon;
                break;
        }
        randomGenerator = new Random();
        numOfWordsToTest = numOfWords;
    }

    /**
     * reduces the number of words left to test.
     * Gets random word from available words.
     * @return next word to test. Null if there are no words left to test.
     */
    public static String nextWord() {
        if(numOfWordsToTest == 0) {
            return null;
        } else {
            numOfWordsToTest--;
            int rand = randomGenerator.nextInt(wordsToTest.size());
            String wordToReturn = wordsToTest.get(rand);
            wordsToTest.remove(rand);
            return wordToReturn;

        }
    }

    /**
     * Adds score to game after picture taken and analysed.
     * @param newWords list of strings in image from microsoft Cognitive services.
     * @param word word that was tested.
     */
    public static void addScore(List<String> newWords, String word) {
        // If word is danish replace with english word to test against.
        if(danishHackathon.contains(word)) {
            int i = danishHackathon.lastIndexOf(word);
            word = hackathon.get(i);
        }
        List<String> list = newWords.subList(1, 6);
        for(String newWord : list) {
            // Converts to lowercase in case of irregular input.
            // If correct adds to statistics.
            if(newWord.toLowerCase().contains(word.toLowerCase())) {
                score++;
                photosTaken++;
                correctPhotosTaken++;
                wordsTested.put(word, true);
                return;
            }
        }
        // If no word found
            photosTaken++;
            wordsTested.put(word, false);
    }

    public static int getScore() {
        return score;
    }

    public static int getCorrectPhotosTaken() {
        return correctPhotosTaken;
    }

    public static int getPhotosTaken() {
        return photosTaken;
    }

    public static TreeMap<String, Boolean> getWordsTested() {
        return wordsTested;
    }
}
