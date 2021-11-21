package com.javarush.task.task04.task0432;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Хорошего много не бывает
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите строку: ");
        String str = scanner.nextLine(), s;
        int n = 0;

        while (true){
//            System.out.print("Введите число N: ");
            if(scanner.hasNextInt()){
                n = scanner.nextInt();
                break;
            } else {
                s = scanner.nextLine();
                if(!s.equals(""))
                    System.out.println(s + " не является целым числом");
                continue;
            }

        }
//        System.out.println(str + " " + n);
        for (int i = 0; i < n; i++)
            System.out.println(str);
    }
}
