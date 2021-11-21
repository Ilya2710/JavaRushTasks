package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }
//  №1
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
//  №2
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
//  №3
    public static void printMatrix(int m, String value) {
        printMatrix(m, m, value);
    }
//  №4
    public static void printMatrix(int m, Object value) {
        printMatrix(m, m, value);
    }
//  №5
    public static void printMatrix(int m) {
        printMatrix(m, m, "8");
    }
//  №6
    public static void printMatrix(String value) {
        printMatrix(10, 10, value);
    }
//  №7
    public static void printMatrix(Object value) {
        printMatrix(10, 10, value);
    }
//  №8
    public static void printMatrix() {
        printMatrix(10, 10, "8");
    }
//  №9
    public static void printMatrix(long m, long n, String value) {
        printMatrix((int) m, (int) n, value);
    }
//  №10
    public static void printMatrix(long m, String value) {
        printMatrix((int) m, value);
    }
}
