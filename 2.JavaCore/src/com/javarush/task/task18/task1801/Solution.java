package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1801/F1season2020.txt

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxByte = 0;
        String fileName = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(fileName);
            while (fis.available() > 0) {
                int readByte = fis.read();
                if (readByte > maxByte)
                    maxByte = readByte;
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(maxByte);
    }
}
