package com.javarush.task.task03.task0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
План по захвату мира
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String name;
        String sAge;

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            // System.out.print("Введите число: ");
            sAge = reader.readLine();
            // System.out.print("Введите имя: ");
            name = reader.readLine();

            System.out.println(name + " захватит мир через " + sAge + " лет. Му-ха-ха!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
