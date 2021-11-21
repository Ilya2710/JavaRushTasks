package com.javarush.task.task04.task0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Сортировка трех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            double[] inputNumbers = new double[3];

            for (int i = 0; i < inputNumbers.length; i++) {
//                System.out.print("Введите число: ");
                inputNumbers[i] = Double.parseDouble(reader.readLine());
            }

            Solution.Sort(inputNumbers);

//            System.out.print("Результат: ");
            for (int i = inputNumbers.length - 1; i >= 0; i--) {
                System.out.print(inputNumbers[i]);
                if (i > 0)
                    System.out.print(" ");
            }
            System.out.println();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Sort(double[] array) {
        double temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
