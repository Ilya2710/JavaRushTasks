package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] sourIntArray = new int[20];
        int[] destIntArray01 = new int[10];
        int[] destIntArray02 = new int[10];

        for (int i = 0; i < sourIntArray.length; i++)
            sourIntArray[i] = readInt();

        arrayIntCopy(sourIntArray, 0, destIntArray01, 0, 10);
        arrayIntCopy(sourIntArray, 10, destIntArray02, 0, 10);
        printIntArray(destIntArray02);
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

    public static void arrayIntCopy(int[] src, int srcPos, int[] dest, int destPos, int length) {
        for (int i = 0; i < length; i++)
            dest[destPos + i] = src[srcPos + i];
    }

    public static void printIntArray(int[] array){
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
}
