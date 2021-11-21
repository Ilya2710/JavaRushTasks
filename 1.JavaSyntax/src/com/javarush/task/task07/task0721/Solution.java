package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int maximum;
        int minimum;

        int[] array = getInts();

        maximum = array[0];
        minimum = array[0];

        for (int i = 1; i < array.length; i++) {
            if(maximum < array[i])
                maximum = array[i];
            if(minimum > array[i])
                minimum = array[i];
        }

        System.out.print(maximum + " " + minimum);
    }

    public static int[] getInts() {
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++)
            array[i] = readInt();

        return array;
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
