package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandFather01 = new Human("Дедушка №1", true, 65);
        Human grandMother01 = new Human("Бабушка №1", false, 64);
        Human grandFather02 = new Human("Дедушка №2", true, 70);
        Human grandMother02 = new Human("Бабушка №2", false, 69);
        Human fatherHuman = new Human("Папа", true, 35, grandFather01, grandMother01);
        Human motherHuman = new Human("Мама", false, 34, grandFather02, grandMother02);
        Human son01 = new Human("Сын №1", true, 10, fatherHuman, motherHuman);
        Human son02= new Human("Сын №2", true, 8, fatherHuman, motherHuman);
        Human daughter = new Human("Дочка", false, 5, fatherHuman, motherHuman);

        System.out.println(grandFather01);
        System.out.println(grandMother01);
        System.out.println(grandFather02);
        System.out.println(grandMother02);
        System.out.println(fatherHuman);
        System.out.println(motherHuman);
        System.out.println(son01);
        System.out.println(son02);
        System.out.println(daughter);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father, mother;

        public Human(String name, boolean sex, int age) {
            this(name, sex, age, null, null);
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}