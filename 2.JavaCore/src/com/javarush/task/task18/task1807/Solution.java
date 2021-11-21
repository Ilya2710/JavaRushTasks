package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1807/F1season2020.txt

public class Solution {
    public static void main(String[] args) {
        byte comma = (byte)',';
        String fileName = null;
        int countCommas = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();

            FileInputStream fis = null;
            fis = new FileInputStream(fileName);

            while (fis.available() > 0) {
                if (fis.read() == comma)
                    countCommas++;
            }
            fis.close();

            System.out.println(countCommas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
