package com.javarush.task.task04.task0443;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Как назвали, так назвали
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

//        System.out.print("Введите год: ");
        int year = readIntNumber(scanner);
//        System.out.print("Введите месяц: ");
        int month = readIntNumber(scanner);
//        System.out.print("Введите число: ");
        int day = readIntNumber(scanner);

        System.out.println("Меня зовут " + name + ".\n" +
                "Я родился " + day + "." + month + "." + year);
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
