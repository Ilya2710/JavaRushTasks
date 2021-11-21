package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++)
            array[i] = readInt();

        for (int i = 0; i < array.length; i++)
            System.out.println(array[array.length - 1 - i]);
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
}

