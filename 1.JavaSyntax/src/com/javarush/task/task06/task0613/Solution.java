package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        Cat[] cats = new Cat[10];

        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat();
        }

//        System.out.print("Количество созданных котов: ");
        System.out.println(Cat.catCount);
    }

    public static class Cat {
        public static int catCount = 0;

        public Cat(){
            catCount++;
        }
    }
}
