package com.javarush.task.task05.task0532;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try {
                int maximum = 0, N;
                N = Integer.parseInt(reader.readLine());
                if(N > 0) {
                    int[] numbers = new int[N];

                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = Integer.parseInt(reader.readLine());
                        if(i == 0)
                            maximum = numbers[i];
                        else if(maximum < numbers[i])
                            maximum = numbers[i];
                    }

                    System.out.println(maximum);
                }
            } catch (NumberFormatException e) {
                System.out.println("Введенное значение не является числом");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
