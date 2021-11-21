package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1816/F1season2020.txt

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String str;
            char strChar[];
            int englishLetters = 0;

            while (reader.ready()) {
                str = reader.readLine();
                strChar = str.toCharArray();
                for (int i = 0; i < strChar.length; i++)
                    if ((65 <= strChar[i] && strChar[i] <= 90) || (97 <= strChar[i] && strChar[i] <= 122))
                        englishLetters++;
            }
            System.out.println(englishLetters);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
