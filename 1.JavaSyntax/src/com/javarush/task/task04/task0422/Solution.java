package com.javarush.task.task04.task0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
18+
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("Введите имя: ");
            String name = reader.readLine();
//            System.out.print("Введите свой возраст: ");
            int age = Integer.parseInt(reader.readLine());

            if(age < 18)
                System.out.println("Подрасти еще");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
