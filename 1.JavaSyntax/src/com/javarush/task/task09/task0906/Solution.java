package com.javarush.task.task09.task0906;

/* 
Логирование стек-трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String text) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTraceElements[2];
        System.out.println(element.getClassName() + ": " + element.getMethodName() + ": " + text);
    }
}
