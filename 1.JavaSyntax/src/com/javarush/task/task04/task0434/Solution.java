package com.javarush.task.task04.task0434;

/* 
Таблица умножения Ӏ Java Syntax: 4 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        int dimensions = 10, i = 1, j;

        while(i <= dimensions) {
            j = 1;
            while (j <= dimensions) {
                System.out.print(i*j);
                if(j != dimensions)
                    System.out.print(" ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
