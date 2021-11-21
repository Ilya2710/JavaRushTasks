package com.javarush.task.task04.task0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Ярлыки и числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("Введите целое число: ");
            int inputNumber = Integer.parseInt(reader.readLine());

            if(inputNumber == 0)
                System.out.println("ноль");
            else {
                if (inputNumber < 0)
                    System.out.print("отрицательное ");
                else
                    System.out.print("положительное ");

                if(inputNumber % 2 == 0)
                    System.out.println("четное число");
                else
                    System.out.println("нечетное число");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
