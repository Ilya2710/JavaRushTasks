package com.javarush.task.task04.task0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Фейс-контроль
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("Введите имя: ");
            String name = reader.readLine();
//            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(reader.readLine());

            if(age > 20)
                System.out.println("И 18-ти достаточно");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
