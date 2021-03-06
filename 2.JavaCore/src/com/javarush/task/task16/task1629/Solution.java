package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread {
        List<String> list = new ArrayList<>();

        @Override
        public void run() {
            try {
                synchronized (reader) {
                    for (int i = 0; i < 3; i++) {
                        list.add(reader.readLine());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void printResult() {
            for (int i = 0; i < this.list.size(); i++) {
                System.out.print(this.list.get(i));
                if (i != this.list.size() - 1)
                    System.out.print(" ");
                else
                    System.out.println();
            }
        }
    }


}
