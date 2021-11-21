package com.javarush.task.task03.task0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Большая и чистая
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name01, name02, name03;

        // System.out.print("Введите первое имя: ");
        name01 = reader.readLine();
        // System.out.print("Введите второе имя: ");
        name02 = reader.readLine();
        // System.out.print("Введите третье имя: ");
        name03 = reader.readLine();

        System.out.println(name01 + " + " + name02 + " + " + name03 + " = Чистая любовь, да-да!");
    }
}