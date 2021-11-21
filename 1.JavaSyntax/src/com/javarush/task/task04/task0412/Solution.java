package com.javarush.task.task04.task0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Положительное и отрицательное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // System.out.print("Введите число: ");
            String inputString = reader.readLine();

            int number = 0;
            if(inputString != null)
                number = Integer.parseInt(inputString);

            if (number > 0)
                number *= 2;
            else if (number < 0)
                number += 1;

            // System.out.print("Результат: ");
            System.out.println(number);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}