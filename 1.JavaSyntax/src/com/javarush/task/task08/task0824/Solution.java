package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> family = new ArrayList<Human>();

        family.add(new Human("Артём", true,  3, new ArrayList<Human>()));
        family.add(new Human("Алиса", false, 1, new ArrayList<Human>()));
        family.add(new Human("Роман", true, 8, new ArrayList<Human>()));
        ArrayList<Human> children = new ArrayList<>();
        children.add(family.get(0));
        children.add(family.get(1));
        children.add(family.get(2));

        family.add(new Human("Илья", true, 38, children));
        ArrayList<Human> fatherIsAChild = new ArrayList<Human>();
        fatherIsAChild.add(family.get(3));

        family.add(new Human("Лена", false, 39, children));
        ArrayList<Human> motherIsAChild = new ArrayList<Human>();
        motherIsAChild.add(family.get(4));

        family.add(new Human("Александр", true, 63, fatherIsAChild));
        family.add(new Human("Елена", false, 62, fatherIsAChild));

        family.add(new Human("Владимир", true, 72, motherIsAChild));
        family.add(new Human("Людмила", false, 71, motherIsAChild));

        for (int i = 0; i < family.size(); i++)
            System.out.println(family.get(i));
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
