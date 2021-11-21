package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer number = null;
            number++;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] a = new int[2];
            for (int i = 0; i < 3; i++) {
                a[i] = 1;
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer.parseInt("five");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            new FileInputStream("abc");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            List<Integer> list = new ArrayList<>(2);
            list.get(6);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int size = -1;
            int[] arr = new int[size];
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.close();
            reader.readLine();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
