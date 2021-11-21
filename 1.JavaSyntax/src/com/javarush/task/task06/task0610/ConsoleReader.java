package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Введите строку: ");
        return reader.readLine();
    }

    public static int readInt() throws Exception {
        String str = null;
        int number;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
                try {
//                    System.out.print("Введите целое число: ");
                    str = reader.readLine();
                    number = Integer.parseInt(str);
                    return number;
                } catch (NumberFormatException e) {
                    System.out.println(str + " не является целым числом");
                    continue;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

    public static double readDouble() throws Exception {
        String str;
        double number;
        Scanner scanner = new Scanner(System.in);

        while(true) {
//            System.out.print("Введите вещественное число: ");
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                return number;
            } else {
                str = scanner.nextLine();
                System.out.println(str + " не является вещественным числом");
            }
        }
    }

    public static boolean readBoolean() throws Exception {
        String str = null;
        boolean number;
        Scanner scanner = new Scanner(System.in);

        while(true) {
//            System.out.print("Введите логическую переменную: ");
            if (scanner.hasNextBoolean()) {
                number = scanner.nextBoolean();
                return number;
            } else {
                str = scanner.nextLine();
                System.out.println(str + " не является логической переменной");
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        String str = readString();
//        System.out.println("readString: " + str);
//        int intNumber = readInt();
//        System.out.println("readInt: " + intNumber);
//        double doubleNumber = readDouble();
//        System.out.println("readDouble: " + doubleNumber);
//        boolean booleanNumber = readBoolean();
//        System.out.println("readBoolean: " + booleanNumber);
    }
}
