package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even = 0;
    public static int odd = 0;

    public static void main(String[] args) throws IOException {
//            System.out.print("Введите целое число: ");
            int number = readIntNumber();
            while(number != 0){
                if(((number % 10) % 2) == 0)
                    even++;
                else
                    odd++;
                number /= 10;
            }
        System.out.println("Even: " + even + " Odd: " + odd);
    }

    public static int readIntNumber(){
        String str;
        try (Scanner scanner = new Scanner(System.in)) {
            for (; true; ) {
                if (scanner.hasNextInt())
                    return scanner.nextInt();
                else {
                    str = scanner.nextLine();
                    if (!str.equals(""))
                        System.out.print(str + " не является целым числом\n" +
                                "Введите целое число: ");
                }
            }
        }
    }
}
