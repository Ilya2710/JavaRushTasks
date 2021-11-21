package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++)
            strings.add(reader.readLine());

        int min = strings.get(0).length();
        int max = min;

        for (String string : strings) {
            if(min > string.length())
                min = string.length();
            if (max < string.length())
                max = string.length();
        }

        for(String string : strings) {
            if(min == string.length() ||  max == string.length()) {
                System.out.println(string);
                break;
            }
        }
    }
}
