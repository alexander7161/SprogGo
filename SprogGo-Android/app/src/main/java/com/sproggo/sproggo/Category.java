package com.sproggo.sproggo;

import java.util.ArrayList;
import java.util.Collections;

public class Category {
    // the array of words to take photos of
    private ArrayList<String> words = new ArrayList<>();

    // the number of words which is assigned depending on the level
    // 5, 10 or 15 corresponding to easy, medium or hard
    public int numOfWords;

    // constructor
    public Category(String[] words) {
        for (int i = 0; i < words.length; i++) {
            this.words.add(words[i]);
        }
    }

    public ArrayList<String> getTestWords() {
        ArrayList<String> testWords = new ArrayList<>();

        // shuffles the array list
        Collections.shuffle(words);

        // takes the first n elements as test words where
        // n is numOfWords and depends on the difficulty setting
        for (int i = 0; i < numOfWords; i++) {
            testWords.add(words.get(i));
        }

        return testWords;
    }

}
