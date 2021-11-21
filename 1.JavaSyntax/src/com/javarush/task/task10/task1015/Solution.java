package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String> [] arrayOfStringList =  new ArrayList[2];
        ArrayList<String> stringList0 = new ArrayList<String>();
        ArrayList<String> stringList1 = new ArrayList<String>();
        arrayOfStringList[0] = stringList0;
        arrayOfStringList[1] = stringList1;

        stringList0.add("String");
        stringList0.add("List");
        stringList0.add("№");
        stringList0.add("1");

        stringList1.add("String");
        stringList1.add("List");
        stringList1.add("№");
        stringList1.add("2");

        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String string : list) {
                System.out.println(string);
            }
        }
    }
}