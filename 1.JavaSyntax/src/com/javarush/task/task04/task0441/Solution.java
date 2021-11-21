package com.javarush.task.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/* 
Как-то средненько
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[3];
        for (int i = 0; i < array.length; i++) {
//            System.out.print("Введите целое число: ");
            array[i] = readIntNumber(scanner);
        }

        Arrays.sort(array);
        System.out.println(array[1]);
    }

    public static int readIntNumber(Scanner scanner){
        String str;
        for(;true;) {
            if(scanner.hasNextInt())
                return scanner.nextInt();
            else {
                str = scanner.nextLine();
                if(!str.equals(""))
                    System.out.print(str + " не является целым числом\n" +
                            "Введите целое число: ");
            }
        }
    }
}
