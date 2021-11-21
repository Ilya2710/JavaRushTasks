package com.javarush.task.task04.task0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Три числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int[] numbers = new int[3];

            for (int i = 0; i < numbers.length; i++) {
    //            System.out.print("Введите число: ");
                numbers[i] = Integer.parseInt(reader.readLine());
            }

            if (numbers[0] == numbers[1] && numbers[0] != numbers[2])
                System.out.println(3);
            else if (numbers[0] == numbers[2] && numbers[0] != numbers[1])
                System.out.println(2);
            else if (numbers[1] == numbers[2] && numbers[1] != numbers[0])
                System.out.println(1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
