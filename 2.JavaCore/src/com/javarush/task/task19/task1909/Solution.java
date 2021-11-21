package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1909/F1season2020_in.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1909/F1season2020_out.txt

public class Solution {
    public static void main(String[] args) {
        try {
            String fileNameIn, fileNameOut;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileNameIn = reader.readLine();
            fileNameOut = reader.readLine();
            reader.close();

            reader = new BufferedReader (new FileReader(fileNameIn));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOut));

            String str = null;
            while ((str = reader.readLine()) != null) {
                str = str.replaceAll("\\.", "!");
                writer.write(str + "\n");
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
