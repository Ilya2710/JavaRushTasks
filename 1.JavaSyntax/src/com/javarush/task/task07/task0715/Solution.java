package com.javarush.task.task07.task0715;

import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "мама", "мыла", "раму");
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, "именно");
        }

        printList(list);
    }

    public static void printList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
