package com.javarush.task.task19.task1926;

import java.io.*;

/* 
Перевертыши
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1926/F1season2020.txt

public class Solution {
    public static void main(String[] args) {
        String fileName = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            while (reader.ready()) {
                String str = reader.readLine();
                char[] strCharArray = str.toCharArray();

                for (int i = strCharArray.length - 1; i >= 0; i--)
                    System.out.print(strCharArray[i]);
                System.out.println();
            }

            reader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
