package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Реверс файла
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1809/F1season2020_in.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1809/F1season2020_out.txt

public class Solution {
    public static void main(String[] args) {
        try {
            String fileNameIn, fileNameOut;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileNameIn = reader.readLine();
            fileNameOut = reader.readLine();
            reader.close();

            List<Integer> list = new ArrayList<>();
            FileInputStream fis = new FileInputStream(fileNameIn);
            while (fis.available() > 0)
                list.add(fis.read());
            fis.close();

            FileOutputStream fos = new FileOutputStream(fileNameOut);
            for (int i = list.size() - 1; i >= 0; i--)
                fos.write(list.get(i));

            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
