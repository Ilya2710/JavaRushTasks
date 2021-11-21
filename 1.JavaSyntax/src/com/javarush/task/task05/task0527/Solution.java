package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Dog spikeDog = new Dog("Spike", 50, 15);
        Cat tomCat = new Cat("Tom", 5, "Gray");
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog{
        String name;
        int height;
        int weight;

        public Dog(String name, int height, int weght){
            this.name = name;
            this.height = height;
            this.weight = weght;
        }
    }

    public static class Cat {
        String name;
        int weight;
        String color;

        public Cat(String name, int weight, String color){
            this.name = name;
            this.weight = weight;
            this.color = color;
        }
    }
}
