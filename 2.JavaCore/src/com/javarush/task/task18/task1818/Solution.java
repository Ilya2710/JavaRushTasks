package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1818/F1season2020_00.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1818/F1season2020_01.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1818/F1season2020_02.txt

public class Solution {
    public static void main(String[] args) {
        String fileName_00, fileName_01, fileName_02;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName_00 = reader.readLine();
            fileName_01 = reader.readLine();
            fileName_02 = reader.readLine();
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName_00, true));
            reader = new BufferedReader(new FileReader(fileName_01));

            while (reader.ready())
                writer.write(reader.read());
            reader.close();

            reader = new BufferedReader(new FileReader(fileName_02));
            while (reader.ready())
                writer.write(reader.read());

            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
