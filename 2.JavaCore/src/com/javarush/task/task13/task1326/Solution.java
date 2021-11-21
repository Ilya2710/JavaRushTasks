package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task13/task1326/InputNumbers.txt

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;

        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        reader = new BufferedReader(new InputStreamReader(fis));
        ArrayList<Integer> list = new ArrayList<>();

        try {
            while(reader.ready()) {
                String str = reader.readLine();
                try {
                    int number = Integer.parseInt(str);
                    if(number % 2 == 0)
                        list.add(number);
                } catch (NumberFormatException e) {
//                    System.out.println(str + " is not a number");
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.sort(null);

        for (Integer number: list) {
            System.out.println(number);
        }

        try {
            fis.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
