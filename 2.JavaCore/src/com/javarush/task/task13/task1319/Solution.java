package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task13/task1319/Consol.txt

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName, stringLine = null;
        BufferedWriter writer = null;

        try {
            fileName = reader.readLine();
            writer = new BufferedWriter(new FileWriter(fileName));

            do {
                stringLine = reader.readLine();
                writer.write(stringLine);
                writer.newLine();
            } while(!stringLine.equals("exit"));

            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
