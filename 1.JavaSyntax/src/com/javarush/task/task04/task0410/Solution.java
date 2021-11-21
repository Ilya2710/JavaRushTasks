package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
        checkInterval(10);
    }

    public static void checkInterval(int a) {
        final int INTERVAL_MIN = 50;
        final int INTERVAL_MAX = 100;

        if(INTERVAL_MIN < a && a < INTERVAL_MAX)
            System.out.println("Число " + a  + " содержится в интервале.");
        else
            System.out.println("Число " + a + " не содержится в интервале.");
    }
}