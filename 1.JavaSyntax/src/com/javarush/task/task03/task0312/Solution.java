package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    //напишите тут ваш код

    public static void main(String[] args) {
        System.out.println(convertToSeconds(1));
        System.out.println(convertToSeconds(5));
    }

    public static int convertToSeconds(int hours) {
        final int MINUTES_IN_HOUR = 60;
        final int SECONDS_IN_MINUTE = 60;

        return hours * MINUTES_IN_HOUR * SECONDS_IN_MINUTE;
    }
}
