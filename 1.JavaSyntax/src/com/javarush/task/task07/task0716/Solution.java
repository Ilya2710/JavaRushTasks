package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        int hasR, hasL;

        for (int i = 0; i < strings.size();) {
            hasR = strings.get(i).indexOf("р");
            hasL = strings.get(i).indexOf("л");

            if(hasR != -1 && hasL == -1) {
                strings.remove(i);
                continue;
            } else if (hasR == -1 && hasL != -1) {
                strings.add(i, strings.get(i));
                i += 2;
                continue;
            }
            i++;
        }

        return strings;
    }
}