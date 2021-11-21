package com.javarush.task.task03.task0314;

/* 
Таблица умножения Ӏ Java Syntax: 3 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        int i = 1, j;

        while (i < 11) {
            j = 1;
            while (j < 11) {
                System.out.print(i * j);
                if (j == 10)
                    System.out.println();
                else
                    System.out.print(" ");
                j++;
            }
            i++;
        }
    }
}
