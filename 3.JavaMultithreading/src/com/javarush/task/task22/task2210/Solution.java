package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String[] str = getTokens("level22.lesson13.task01", ".");

        for (String s : str)
            System.out.println(s);
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] result = new String[stringTokenizer.countTokens()];
        System.out.println(result.length);

        int i = 0;
        while (stringTokenizer.hasMoreTokens())
            result[i++] = stringTokenizer.nextToken();

        return result;
    }
}
