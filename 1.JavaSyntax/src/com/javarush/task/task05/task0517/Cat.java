package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name, address, color;
    int age, weight;

    public Cat(String name){
        this.name = name;
        this.age = 5;
        this.weight = 4;
        this.color = "Black";
        this.address = null;
    }

    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "Black";
        this.address = null;
    }

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = 4;
        this.color = "Black";
        this.address = null;
    }

    public Cat(int weight, String color){
        this.name = null;
        this.age = 5;
        this.weight = weight;
        this.color = color;
        this.address = null;
    }

    public Cat(int weight, String color, String address){
        this.name = null;
        this.age = 5;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
