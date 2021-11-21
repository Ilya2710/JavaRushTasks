package com.javarush.task.task04.task0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Максимум четырех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            double[] inputNumbers = new double[4];

            for (int i = 0; i < inputNumbers.length; i++){
                // System.out.print("Введите число: ");
                inputNumbers[i] = Double.parseDouble(reader.readLine());
            }

            double max = inputNumbers[0];
            for (int i = 1; i < inputNumbers.length; i++)
                if (max < inputNumbers[i])
                    max = inputNumbers[i];

            System.out.println(max);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
