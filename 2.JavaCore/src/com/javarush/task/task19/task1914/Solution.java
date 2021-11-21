package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();

        String[] str = outputStream.toString().split(" ");
        String result;
        int a = 0, b = 0, c = 0;
        try {
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        switch (str[1]) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
        }

        result = a + " " + str[1] + " " + b + " = " + c;

        System.setOut(consoleStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

