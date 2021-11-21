package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        ArrayList<Character> listVowels = new ArrayList<>(10);
        ArrayList<Character> listConsonants = new ArrayList<>(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();
        char[] wordCharArray = word.toCharArray();

        for (int i = 0; i < wordCharArray.length; i++) {
            if(wordCharArray[i] == ' ') {
                continue;
            }
            else if(isVowel(wordCharArray[i])) {
                listVowels.add(wordCharArray[i]);
            } else {
                listConsonants.add(wordCharArray[i]);
            }
        }

        for (int i = 0; i < listVowels.size(); i++)
            System.out.print(listVowels.get(i) + " ");
        System.out.println();
        for (int i = 0; i < listConsonants.size(); i++)
            System.out.print(listConsonants.get(i) + " ");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}