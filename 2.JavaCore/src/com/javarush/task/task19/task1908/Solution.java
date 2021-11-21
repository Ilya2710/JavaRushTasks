package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1908/Text_in.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1908/Text_out.txt

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

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] strArray = line.split(" ");
                for (String str : strArray)
                    if (isANumber(str))
                        writer.write(str + " ");
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isANumber(String str) {
        if (str == null || str.length() == 0)
            return false;

        for (Character ch : str.toCharArray())
            if (!Character.isDigit(ch))
                return false;

        return true;
    }
}
