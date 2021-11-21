package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
*/

public class Solution {
    public static class Idea{
        String description;

        public  Idea() {
            this.description = "Description of the Idea";
        }

        public String getDescription(){
            return description;
        }
    }

    public static void main(String[] args) {
        printIdea(new Idea());
    }

    public static void printIdea(Idea idea){
        System.out.println(idea.getDescription());
    }
}
