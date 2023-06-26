package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printFullStackTrace(e);
    }

    public void printFullStackTrace(Throwable e) {
        Throwable cause = e.getCause();
        if (cause != null)
            printFullStackTrace(cause);
        System.out.println(e.getClass().getName() + ": " + e.getMessage());
    }

    public static void main(String[] args) {
    }
}
