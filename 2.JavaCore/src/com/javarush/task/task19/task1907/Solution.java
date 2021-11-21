package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1907/F1season2020.txt

public class Solution {
    public static void main(String[] args) {
        int counter = 0;
        String word = "world";
//        String word = "контракт";

        try {
            String fileName;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();

            FileReader fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);

            int index;
            while (reader.ready()) {
                String str = reader.readLine().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");
                String[] strArray = str.split(" ");

                for (int i = 0; i < strArray.length; i++)
                    if (strArray[i].equals(word))
                        counter++;
            }

            reader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }
}
