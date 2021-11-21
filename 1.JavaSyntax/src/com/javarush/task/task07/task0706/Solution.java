package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int sumEven = 0, sumOdd = 0;
        int[] array = new int[15];

        for (int i = 0; i < array.length; i++) {
            array[i] = readInt();
        }

        for (int i = 0; i < array.length; i++) {
            if(i % 2 == 0)
                sumEven += array[i];
            else
                sumOdd += array[i];
        }

        if(sumEven > sumOdd)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else if (sumEven < sumOdd)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
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
