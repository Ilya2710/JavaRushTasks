package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        double sum = 0.0, number;
        String str;
        final String SHOW_SUMM = "сумма";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
//                System.out.print("Введите число: ");
                str = reader.readLine();

                if(str.equals(SHOW_SUMM))
                    break;
                try {
                    if(str != null) {
                        number = Double.parseDouble(str);
                        sum += number;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(str + " не является числом");
                    continue;
                }

            }
        }
        System.out.println(sum);
    }
}
