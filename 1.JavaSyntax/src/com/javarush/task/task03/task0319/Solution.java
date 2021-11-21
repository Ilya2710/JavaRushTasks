package com.javarush.task.task03.task0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Предсказание на будущее
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String name, sum, years;

        // System.out.print("Введите имя: ");
        name = reader.readLine();
        // System.out.print("Введите сумму: ");
        sum = reader.readLine();
        // System.out.print("Введите количество лет: ");
        years = reader.readLine();

        System.out.println(name  + " получает " + sum + " через " + years + " лет.");
    }
}
