package com.sproggo.sproggo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {
    private Random randomGenerator;
    private List<String> wordsToTest;
    private int numOfWordsToTest;
    private List<String> hackathon = new LinkedList<String>(Arrays.asList("laptop", "phone", "water", "chair", "table", "fruit"));
    private List<String> animal = new LinkedList<String>(Arrays.asList("dog", "cat", "pig", "sheep", "cow", "horse", "spider", "hippopotamus", "elephant"));
    private List<String> garden = new LinkedList<String>(Arrays.asList("flower", "tree", "grass"));
    private int score;
    private int photosTaken;
    private int correctPhotosTaken;
    private TreeMap<String, Boolean> wordsTested;

    private Game() {
    }

    public Game(String categoryName, int numOfWords) {
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

    public String nextWord() {
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

    public void addScore(List<String> newWords, String word) {
        boolean isCorrect = false;
        boolean done = false;
        List<String> list = newWords.subList(1, 6);
        for(String newWord : list) {
            if(newWord.toLowerCase().contains(word.toLowerCase()) && !done) {
                score++;
                photosTaken++;
                correctPhotosTaken++;
                isCorrect = true;
                wordsTested.put(word, true);
                done = true;
            } else {
                photosTaken++;
                wordsTested.put(word, false);
            }
        }
    }

    public int getScore() {
        return score;
    }

    public int getCorrectPhotosTaken() {
        return correctPhotosTaken;
    }

    public int getPhotosTaken() {
        return photosTaken;
    }

    public TreeMap<String, Boolean> getWordsTested() {
        return wordsTested;
    }
}
