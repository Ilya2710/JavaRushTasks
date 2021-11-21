package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {

    public static void main(String[] args) {
        Cat cat01 = new Cat("Барсик", 3, 3, 3);
        Cat cat02 = new Cat("Васька", 4,4, 4);
        Cat cat03 = new Cat("Тишка", 5, 5, 5);

        System.out.println(cat01.fight(cat02));
        System.out.println(cat01.fight(cat03));
        System.out.println(cat02.fight(cat03));
    }

    public static class Cat {

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageScore = Integer.compare(this.age, anotherCat.age);
            int weightScore = Integer.compare(this.weight, anotherCat.weight);
            int strengthScore = Integer.compare(this.strength, anotherCat.strength);

            int score = ageScore + weightScore + strengthScore;
            return score > 0; // return score > 0 ? true : false;
        }
    }
}
