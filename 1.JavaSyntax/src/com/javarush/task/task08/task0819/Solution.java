package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Iterator<Cat> iterator =cats.iterator();
        Cat cat = iterator.next();
        cats.remove(cat);

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<Cat>();

        cats.add(new Cat("Tom"));
        cats.add(new Cat("Fred"));
        cats.add(new Cat("Pushok"));

        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        Iterator<Cat> iterator = cats.iterator();

        while (iterator.hasNext()) {
            Cat cat = iterator.next();
            System.out.println(cat);
        }
    }

    public static class Cat{
        String name;

        Cat () {
            name = "Unknown cat";
        }

        Cat (String name) {
            this.name = name;
        }
    }
}
