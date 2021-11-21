package com.javarush.task.task04.task0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Положительные и отрицательные числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int negativeNumbers = 0, positiveNumbers = 0, i = 0, number;
        String s;

        while(i < 3) {
//            System.out.print("Введите целое число: ");
            if(scanner.hasNextInt()) {
                number = scanner.nextInt();
                if(number > 0)
                    positiveNumbers++;
                else if(number < 0)
                    negativeNumbers++;
                i++;
            } else {
                s = scanner.nextLine();
                if(!s.equals(""))
                System.out.println(s +  " не является целым числом");
            }
        }
        scanner.close();
        System.out.println("количество отрицательных чисел: " + negativeNumbers);
        System.out.println("количество положительных чисел: " + positiveNumbers);
    }
}
