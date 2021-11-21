package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            double sum = 0.0;
            int N = 0, number;

            while (true){
//                System.out.print("Введите число: ");
                number = readIntNumber(scanner);
                if(number == -1)
                    break;
                sum += number;
                N++;
            }
//            System.out.print("Среднее арифметическое чисел: ");
            System.out.println(sum / N);
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
                    System.out.print(str + " не является целым числом\n" +
                            "Введите целое число: ");
            }
        }
    }
}

