package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1819/F1season2020.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1819/MSchumacher.txt

public class Solution {
    public static void main(String[] args) {
        String fileName_01 = "", fileName_02 = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName_01 = reader.readLine();
            fileName_02 = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName_01);
            int[] firstFile = new int[fileInputStream.available()];

            int i = 0;
            while (fileInputStream.available() > 0) {
                firstFile[i] = fileInputStream.read();
                i++;
            }
            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(fileName_01);
            fileInputStream = new FileInputStream(fileName_02);

            while (fileInputStream.available() > 0)
                fileOutputStream.write(fileInputStream.read());

            for (int j = 0; j < firstFile.length; j++)
                fileOutputStream.write(firstFile[j]);

            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
