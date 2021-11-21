package com.javarush.task.task03.task0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // System.out.print("Введите ожидаемую почасовую зарплату: ");
        n = Integer.parseInt(reader.readLine());

        System.out.println("Я буду зарабатывать $" + n + " в час");
    }
}