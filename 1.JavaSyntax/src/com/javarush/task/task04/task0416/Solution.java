package com.javarush.task.task04.task0416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Переходим дорогу вслепую
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            // System.out.print("Введите t: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputString = reader.readLine();

            double t = Double.parseDouble(inputString);

            t %= 5.0;

            if(0 <= t && t < 3)
                System.out.println("зелёный");
            else if(3 <= t && t < 4)
                System.out.println("жёлтый");
            else
                System.out.println("красный");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}