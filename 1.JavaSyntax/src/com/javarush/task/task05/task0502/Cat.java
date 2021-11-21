package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {

    }

    public boolean fight(Cat anotherCat) {
        int thisCatPoints = 0, anotherCatPoints = 0;

        if(this.age > anotherCat.age)
            thisCatPoints++;
        else if(this.age < anotherCat.age)
            anotherCatPoints++;

        if(this.weight > anotherCat.weight)
            thisCatPoints++;
        else if(this.weight < anotherCat.weight)
            anotherCatPoints++;

        if(this.strength > anotherCat.strength)
            thisCatPoints++;
        else if(this.strength < anotherCat.strength)
            anotherCatPoints++;

        if(thisCatPoints > anotherCatPoints)
            return true;
        else if(thisCatPoints < anotherCatPoints)
            return false;
        else
            return this.hashCode() > anotherCat.hashCode();
    }

    public static void main(String[] args) {

    }
}
