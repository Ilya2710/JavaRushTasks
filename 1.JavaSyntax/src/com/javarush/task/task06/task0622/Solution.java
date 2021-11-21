package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++)
            array[i] = readInt();

        sortIntArray(array);
        printIntArray(array);
    }

    public static int readInt(){
        String str = "";
        int number;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try {
//                System.out.print("Введите целое число: ");
                str = reader.readLine();
                number = Integer.parseInt(str);
                return number;
            } catch (NumberFormatException e){
                System.out.println(str + " не является целым числом");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void sortIntArray(int[] array){
        int temp;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if(array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
}
