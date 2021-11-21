package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1824/F1season2020.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1824/MSchumacher.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1824/Table.txt

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String str = reader.readLine();
                try {
                    FileInputStream fis = new FileInputStream(str);
                    fis.close();
                } catch (FileNotFoundException e) {
                    System.out.println(str);
                    break;
                }
            }
            reader.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
