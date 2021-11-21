package com.javarush.task.task04.task0442;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int sum = 0, number;

        while (true){
//            System.out.print("Введите целое число: ");
            number = readIntNumber(scanner);
            sum += number;
            if(number == -1)
                break;
        }
        System.out.println(sum);
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
