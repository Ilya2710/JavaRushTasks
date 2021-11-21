package com.javarush.task.task18.task1817;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/* 
Пробелы
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1817/F1season2020.txt

public class Solution {
    public static void main(String[] args) {
        int counterWhitespaces = 0, counterTotal = 0;
        try {
            FileReader fileReader = new FileReader(args[0]);
            while (fileReader.ready()) {
                int symbol = fileReader.read();
                counterTotal++;
                if (symbol == (int)' ')
                    counterWhitespaces++;
            }

            System.out.println(String.format(Locale.US, "%.2f", 1.0*counterWhitespaces/counterTotal*100));

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
