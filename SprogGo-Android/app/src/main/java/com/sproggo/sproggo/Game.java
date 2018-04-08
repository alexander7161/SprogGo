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
    private static List<String> wordsToTest;
    private static int numOfWordsToTest;
    private static List<String> hackathon = new LinkedList<String>(Arrays.asList("laptop", "phone", "water", "chair", "table", "fruit"));
    private static List<String> animal = new LinkedList<String>(Arrays.asList("dog", "cat", "pig", "sheep", "cow", "horse", "spider", "hippopotamus", "elephant"));
    private static List<String> garden = new LinkedList<String>(Arrays.asList("flower", "tree", "grass"));
    private static List<String> hackathon = new LinkedList<String>(Arrays.asList("baerbar", "telefon", "vand", "stol", "bord", "frugt"))
    private static int score;
    private static int photosTaken;
    private static int correctPhotosTaken;
    private static TreeMap<String, Boolean> wordsTested;

    private Game() {
    }

    public static void setUpGame(String categoryName, int numOfWords) {
        score = 0;
        photosTaken = 0;
        correctPhotosTaken = 0;
        wordsTested = new TreeMap<>();

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
            int rand = randomGenerator.nextInt(wordsToTest.size());
            String wordToReturn = wordsToTest.get(rand);
            wordsToTest.remove(rand);
            return wordToReturn;

        }
    }

    public static void addScore(List<String> newWords, String word) {
        boolean isCorrect = false;
        List<String> list = newWords.subList(1, 6);
        for(String newWord : list) {
            if(newWord.toLowerCase().contains(word.toLowerCase())) {
                score++;
                photosTaken++;
                correctPhotosTaken++;
                isCorrect = true;
                wordsTested.put(word, true);
                return;
            }
        }
        if(!isCorrect) {
            photosTaken++;
            wordsTested.put(word, false);
        }

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
