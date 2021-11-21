package com.javarush.task.task04.task0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Количество дней в году
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            // System.out.print("Введите год: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputString = reader.readLine();

            int year = Integer.parseInt(inputString);
            int days = 365;

            if (year % 400 == 0)
                days = 366;
            else if (year % 100 != 0 && year % 4 == 0)
                days = 366;

            System.out.println("количество дней в году: " + days);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}