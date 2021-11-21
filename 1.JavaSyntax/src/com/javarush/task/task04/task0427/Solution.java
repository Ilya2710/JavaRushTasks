package com.javarush.task.task04.task0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Описываем числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Введите целое число в диапазоне 1 - 999: ");
        int number = Integer.parseInt(reader.readLine());

        if(number >= 1 && number <= 999) {
            if(number % 2 == 0)
                System.out.print("четное ");
            else
                System.out.print("нечетное ");

            int digits = 0;

            do {
                digits++;
                number /= 10;
            } while (number != 0);

            switch (digits) {
                case 1:
                    System.out.println("однозначное число");
                    break;
                case 2:
                    System.out.println("двузначное число");
                    break;
                case 3:
                    System.out.println("трехзначное число");
            }
        }
    }
}
