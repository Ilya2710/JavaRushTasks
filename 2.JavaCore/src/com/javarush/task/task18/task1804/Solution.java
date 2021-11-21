package com.javarush.task.task18.task1804;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Самые редкие байты
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1804/F1season2020.txt

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = null;
        int[] byteArray = new int[256];

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();

            FileInputStream fis = null;
            fis = new FileInputStream(fileName);

            while(fis.available() > 0)
                byteArray[fis.read()]++;
            fis.close();

            int minCount = -1;
            for (int i = 0; i < byteArray.length; i++)
                if ((byteArray[i] != 0) && (minCount > byteArray[i] || minCount == -1))
                    minCount = byteArray[i];

            for (int i = 0; i < byteArray.length; i++)
                if (byteArray[i] == minCount)
                    System.out.print(i + " ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
