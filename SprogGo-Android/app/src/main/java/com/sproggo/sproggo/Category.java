package com.sproggo.sproggo;

import java.util.ArrayList;
import java.util.Collections;

public class Category {
    private ArrayList<String> words = new ArrayList<>();

    public int numOfWords;

    // constructor takes array of words and adds them to an array list
    public Category(String[] words) {
        for (int i = 0; i < words.length; i++) {
            this.words.add(words[i]);
        }
    }

    // shuffles the array list and then takes the first n elements as test words
    public ArrayList<String> getTestWords() {
        ArrayList<String> testWords = new ArrayList<>();
        Collections.shuffle(words);

        for (int i = 0; i < numOfWords; i++) {
            testWords.add(words.get(i));
        }

        return testWords;
    }

    public static void main(String[] args) {

    }

}
