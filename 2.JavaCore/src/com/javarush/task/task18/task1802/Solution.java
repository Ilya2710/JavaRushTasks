package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1802/F1season2020.txt

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fis = new FileInputStream(fileName);
        int minByte = fis.read();

        while (fis.available() > 0) {
            int readByte = fis.read();
            if (minByte > readByte)
                minByte = readByte;
        }

        fis.close();

        System.out.println(minByte);
    }
}
