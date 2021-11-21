package com.javarush.task.task01.task0134;

/* 
Набираем воду в бассейн
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getVolume(25, 5, 2));
    }

    public static long getVolume(int a, int b, int c) {
        final int LITERS_IN_CUBIC_METER = 1000;

        return a * b * c * LITERS_IN_CUBIC_METER;
    }
}