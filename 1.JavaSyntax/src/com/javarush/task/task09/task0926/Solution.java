package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<int[]>();

        int[] array00 = {0, 1, 2, 3, 4};
        int[] array01 = {10, 11};
        int[] array02 = {100, 101, 102, 103};
        int[] array03 = {1000, 1001, 1002, 1003, 1004, 1005, 1006};
        int[] array04 = new int[0];

        list.add(array00);
        list.add(array01);
        list.add(array02);
        list.add(array03);
        list.add(array04);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
