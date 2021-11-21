package com.javarush.task.task06.task0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Исправляем ошибки юности
*/

public class Solution {
    public static int max = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String maxString = "The max is ";
        int a = 0, b = 0;
        String str = "";
        while(true) {
            try {
//                System.out.print("Введите целое число: ");
                str = reader.readLine();
                a = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println(str + " не является целым числом");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while(true) {
            try {
//                System.out.print("Введите целое число: ");
                str = reader.readLine();
                b = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println(str + " не является целым числом");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        max = a > b ? a : b;

        System.out.println(maxString + max);
    }

}
