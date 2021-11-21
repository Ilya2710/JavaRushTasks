package com.javarush.task.task04.task0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Существует ли пара?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            String[] inputString = new String[3];
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for(int i = 0; i < inputString.length; i++){
//                System.out.print("Введите число: ");
                inputString[i] = reader.readLine();
            }

            int[] inputNumber = new int[3];
            for(int i = 0; i < inputNumber.length; i++)
                inputNumber[i] = Integer.parseInt(inputString[i]);

            if(inputNumber[0] == inputNumber[1] && inputNumber[1] == inputNumber[2])
                System.out.println(inputNumber[0] + " " + inputNumber[1] + " " + inputNumber[2]);
            else if(inputNumber[0] == inputNumber[1])
                System.out.println(inputNumber[0] + " " + inputNumber[1]);
            else if(inputNumber[0] == inputNumber[2])
                System.out.println(inputNumber[0] + " " + inputNumber[2]);
            else if(inputNumber[1] == inputNumber[2])
                System.out.println(inputNumber[1] + " " + inputNumber[2]);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}