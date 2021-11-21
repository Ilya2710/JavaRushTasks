package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread.currentThread().setName("Main");
        threads.add(new Thread(new Thread01()));
        threads.add(new Thread(new Thread02()));
        threads.add(new Thread(new Thread03()));
        threads.add(new Thread04());
        threads.add(new Thread(new Thread05()));
    }
    public static void main(String[] args) {
    }

    public static class Thread01 implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static class Thread02 implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getClass().getSimpleName());
            }
        }
    }

    public static class Thread03 implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static class Thread04 extends Thread implements Message {
        @Override
        public void run() {
            try {
                while (Thread.currentThread().isAlive()) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Thread05 implements Runnable {
        @Override
        public void run() {
            int result = 0;
            String str = "";
            int num;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                while (!((str = reader.readLine()).equals("N"))) {
                    try {
                        num = Integer.parseInt(str);
                        result += num;
                    } catch (NumberFormatException e) {
                        System.out.println(str + " не является целым числом");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(result);
        }
    }
}