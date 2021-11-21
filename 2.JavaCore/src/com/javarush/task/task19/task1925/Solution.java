package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/*
Длинные слова
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1925/Words_in.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1925/Words_out.txt

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(args[0]);
            FileWriter fileWriter = new FileWriter(args[1]);
            BufferedReader reader = new BufferedReader(fileReader);

            boolean isFistrWord = true;
            while (reader.ready()) {
                String line  = reader.readLine();
                String[] strings = line.split(" ");
                for (String str : strings) {
                    if (str.length() > 6) {
                        if (!isFistrWord)
                            fileWriter.write(",");
                        fileWriter.write(str);
                        isFistrWord = false;
                    }
                }
            }

            reader.close();
            fileReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
