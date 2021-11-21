package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        ArrayList<Cat> list = new ArrayList<Cat>();
        for (int i = 0; i < 10; i++) {
            list.add(new Cat("№" + i));
        }

        Map<String, Cat> map = new HashMap<String, Cat>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).name, list.get(i));
        }
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> cats = new HashSet<Cat>();
        cats.addAll(map.values());

        return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }
}
