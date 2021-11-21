package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same");
        System.out.println(list);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        if (words == null || words.length == 0)
            return null;

        List<Word> list = new ArrayList<>();

        for (int j = 0; j < crossword.length; j++)
            for (int i = 0; i < crossword[j].length; i++)
                for (int k = 0; k < words.length; k++)
                    if (crossword[j][i] == words[k].charAt(0))
                        checkPosition(crossword, i, j, words[k], list);

        return list;
    }

    public static void checkPosition (int[][] crossword, int startX, int startY, String word, List<Word> list) {
        if (word == null || word.length() == 0)
            return;

        int endX, endY, wordLength;

        // #1
        endX = startX;
        endY = startY;
        wordLength = 1;
        while (true) {
            if (wordLength == word.length()) {
                Word newWord = new Word(word);
                newWord.setStartPoint(startX, startY);
                newWord.setEndPoint(endX, endY);
                list.add(newWord);
                break;
            }

            endY--;
            wordLength++;

            if(endX < 0 || endX == crossword[startY].length || endY < 0 || endY == crossword.length)
                break;
            if (crossword[endY][endX] != word.charAt(wordLength-1))
                break;
        }

        // #2
        endX = startX;
        endY = startY;
        wordLength = 1;
        while (true) {
            if (wordLength == word.length()) {
                Word newWord = new Word(word);
                newWord.setStartPoint(startX, startY);
                newWord.setEndPoint(endX, endY);
                list.add(newWord);
                break;
            }

            endX++;
            endY--;
            wordLength++;

            if(endX < 0 || endX == crossword[startY].length || endY < 0 || endY == crossword.length)
                break;
            if (crossword[endY][endX] != word.charAt(wordLength-1))
                break;
        }

        // #3
        endX = startX;
        endY = startY;
        wordLength = 1;
        while (true) {
            if (wordLength == word.length()) {
                Word newWord = new Word(word);
                newWord.setStartPoint(startX, startY);
                newWord.setEndPoint(endX, endY);
                list.add(newWord);
                break;
            }

            endX++;
            wordLength++;

            if(endX < 0 || endX == crossword[startY].length || endY < 0 || endY == crossword.length)
                break;
            if (crossword[endY][endX] != word.charAt(wordLength-1))
                break;
        }

        // #4
        endX = startX;
        endY = startY;
        wordLength = 1;
        while (true) {
            if (wordLength == word.length()) {
                Word newWord = new Word(word);
                newWord.setStartPoint(startX, startY);
                newWord.setEndPoint(endX, endY);
                list.add(newWord);
                break;
            }

            endX++;
            endY++;
            wordLength++;

            if(endX < 0 || endX == crossword[startY].length || endY < 0 || endY == crossword.length)
                break;
            if (crossword[endY][endX] != word.charAt(wordLength-1))
                break;
        }

        // #5
        endX = startX;
        endY = startY;
        wordLength = 1;
        while (true) {
            if (wordLength == word.length()) {
                Word newWord = new Word(word);
                newWord.setStartPoint(startX, startY);
                newWord.setEndPoint(endX, endY);
                list.add(newWord);
                break;
            }

            endY++;
            wordLength++;

            if(endX < 0 || endX == crossword[startY].length || endY < 0 || endY == crossword.length)
                break;
            if (crossword[endY][endX] != word.charAt(wordLength-1))
                break;
        }

        // #6
        endX = startX;
        endY = startY;
        wordLength = 1;
        while (true) {
            if (wordLength == word.length()) {
                Word newWord = new Word(word);
                newWord.setStartPoint(startX, startY);
                newWord.setEndPoint(endX, endY);
                list.add(newWord);
                break;
            }

            endX--;
            endY++;
            wordLength++;

            if(endX < 0 || endX == crossword[startY].length || endY < 0 || endY == crossword.length)
                break;
            if (crossword[endY][endX] != word.charAt(wordLength-1))
                break;
        }

        // #7
        endX = startX;
        endY = startY;
        wordLength = 1;
        while (true) {
            if (wordLength == word.length()) {
                Word newWord = new Word(word);
                newWord.setStartPoint(startX, startY);
                newWord.setEndPoint(endX, endY);
                list.add(newWord);
                break;
            }

            endX--;
            wordLength++;

            if(endX < 0 || endX == crossword[startY].length || endY < 0 || endY == crossword.length)
                break;
            if (crossword[endY][endX] != word.charAt(wordLength-1))
                break;
        }

        // #8
        endX = startX;
        endY = startY;
        wordLength = 1;
        while (true) {
            if (wordLength == word.length()) {
                Word newWord = new Word(word);
                newWord.setStartPoint(startX, startY);
                newWord.setEndPoint(endX, endY);
                list.add(newWord);
                break;
            }

            endX--;
            endY--;
            wordLength++;

            if(endX < 0 || endX == crossword[startY].length || endY < 0 || endY == crossword.length)
                break;
            if (crossword[endY][endX] != word.charAt(wordLength-1))
                break;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
