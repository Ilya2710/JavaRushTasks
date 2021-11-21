package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {
        int secondsAfter15 = 0;
        int minutesAfter15 = 30;
        final int SECONDS_IN_MINUTE = 60;

        secondsAfter15 = minutesAfter15 * SECONDS_IN_MINUTE;

        System.out.println(secondsAfter15);
    }
}