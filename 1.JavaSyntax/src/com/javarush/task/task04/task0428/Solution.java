package com.javarush.task.task04.task0428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Положительное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int positiveNumbers = 0;
            for (int i = 0; i < 3; i++) {
//                System.out.print("Введите оценку: ");
                if(Integer.parseInt(reader.readLine()) > 0)
                    positiveNumbers++;
            }

            System.out.println(positiveNumbers);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
