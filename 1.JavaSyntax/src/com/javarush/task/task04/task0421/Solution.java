package com.javarush.task.task04.task0421;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Настя или Настя?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = new String[2];

        for (int i = 0; i < names.length; i++) {
//            System.out.print("Введите имя: ");
            names[i] = reader.readLine();
        }

        if(names[0].equals(names[1]))
            System.out.println("Имена идентичны");
        else if (names[0].length() == names[1].length())
            System.out.println("Длины имен равны");
    }
}
