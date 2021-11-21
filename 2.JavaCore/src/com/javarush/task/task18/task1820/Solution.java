package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1820/DoubleStream_in.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1820/DoubleStream_out.txt

public class Solution {
    public static void main(String[] args) {
        try {
            String fileNameIn, fileNameOut;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileNameIn = reader.readLine();
            fileNameOut = reader.readLine();
            reader.close();

            reader = new BufferedReader(new FileReader(fileNameIn));
            FileWriter writer = new FileWriter(fileNameOut);

            while (reader.ready()) {
                String[] str = reader.readLine().split(" ");
                for (int i = 0; i < str.length; i++) {
                    String numberStr = str[i];
                    float numberFloat = Float.parseFloat(numberStr);
                    int number = Math.round(numberFloat);
                    writer.write(String.format("%d", number));
                    if (i != str.length - 1)
                        writer.write(String.format(" "));
                }
                writer.write(String.format("\n"));
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
