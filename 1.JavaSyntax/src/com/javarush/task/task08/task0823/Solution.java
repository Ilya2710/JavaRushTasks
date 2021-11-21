package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        char[] array = string.toCharArray();

        boolean whitespace = true;
        for (int i = 0; i < array.length; i++) {
            if (whitespace) {
                array[i] = Character.toUpperCase(array[i]);
                whitespace = false;
            }
            if(array[i] == ' ')
                whitespace = true;
        }

        System.out.println(array);
    }
}
