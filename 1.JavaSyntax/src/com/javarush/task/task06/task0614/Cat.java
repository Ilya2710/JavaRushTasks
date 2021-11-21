package com.javarush.task.task06.task0614;

import java.util.ArrayList;
import java.util.ListIterator;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<Cat>();

    public Cat() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            cats.add(new Cat());

        printCats();
    }

    public static void printCats() {
        ListIterator<Cat> listIterator = cats.listIterator();
        while (listIterator.hasNext())
            System.out.println(listIterator.next());
    }
}
