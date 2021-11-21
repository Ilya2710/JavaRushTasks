package com.javarush.task.task04.task0418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимум двух чисел Ӏ Java Syntax: 4 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int[] inputNumbers = new int[2];

            for (int i = 0; i < 2; i++) {
//                System.out.print("Введите целое число: ");
                inputNumbers[i] = Integer.parseInt(reader.readLine());
            }

            if (inputNumbers[0] <= inputNumbers[1])
                System.out.println(inputNumbers[0]);
            else
                System.out.println(inputNumbers[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}