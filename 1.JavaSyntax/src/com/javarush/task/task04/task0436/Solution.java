package com.javarush.task.task04.task0436;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Рисуем прямоугольник
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int m, n;
//        System.out.print("Введите число m: ");
        m = readIntNumber(scanner);
//        System.out.print("Введите число n: ");
        n = readIntNumber(scanner);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print("8");
            System.out.println();
        }
    }

    public static int readIntNumber(Scanner scanner){
        String str;
        for(;true;) {
            if(scanner.hasNextInt())
                return scanner.nextInt();
            else {
                str = scanner.nextLine();
                if(!str.equals(""))
                    System.out.print(str + " не является целым числом\nВведите целое число: ");
            }
        }
    }
}
