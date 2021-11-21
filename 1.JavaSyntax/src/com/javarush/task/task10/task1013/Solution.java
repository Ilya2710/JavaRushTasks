package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private String address;
        private String profession;
        private Human[] parrents;

        // №1
        public Human(String name, boolean sex, int age, String address, Human[] parrents) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.address = address;
            this.parrents = parrents;
        }

        // №2
        public Human() {
            this("No name", true, 0, null, null);
        }

        // №3
        public Human(String name) {
            this(name, true, 0, null, null);
        }

        // №4
        public Human(String name, boolean sex) {
            this(name, sex, 0, null, null);
        }

        // №5
        public Human(String name, boolean sex, int age) {
            this(name, sex, age, null, null);
        }

        // №6
        public Human(String name, boolean sex, int age, String address){
            this(name, sex, age, address, null);
        }

        // №7
        public Human(String name, boolean sex, int age, Human[] parrents){
            this(name, sex, age, null, parrents);
        }

        // №8
        public Human(String name, int age){
            this(name, true, age, null, null);
        }

        //№9
        public Human(String name, boolean sex, Human[] parrents) {
            this(name, sex, 0, null, parrents);
        }

        // №10
        public Human(String name, int age, Human[] parrents){
            this(name, true, age, null, parrents);
        }
    }
}
