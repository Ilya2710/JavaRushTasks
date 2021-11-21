package com.javarush.task.task04.task0415;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Правило треугольника
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            String[] inputSide = new String[3];

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // System.out.print("Введите сторону a: ");
            inputSide[0] = reader.readLine();
            // System.out.print("Введите сторону b: ");
            inputSide[1] = reader.readLine();
            // System.out.print("Введите сторону c: ");
            inputSide[2] = reader.readLine();

            int[] side = new int[3];
            side[0] = Integer.parseInt(inputSide[0]);
            side[1] = Integer.parseInt(inputSide[1]);
            side[2] = Integer.parseInt(inputSide[2]);

            Arrays.sort(side);

            if(side[0] + side[1] <= side[2])
                System.out.println("Треугольник не существует.");
            else
                System.out.println("Треугольник существует.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}