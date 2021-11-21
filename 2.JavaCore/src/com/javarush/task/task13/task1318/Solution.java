package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Чтение файла
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task13/task1318/F1season2020.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inStream = new FileInputStream(fileName);
        reader = new BufferedReader(new InputStreamReader(inStream));

        while(reader.ready()) {
                System.out.println(reader.readLine());
            }
        inStream.close();
        reader.close();
    }
}