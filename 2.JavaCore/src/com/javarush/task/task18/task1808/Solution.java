package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1808/F1season2020_in.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1808/F1season2020_out_p1.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1808/F1season2020_out_p2.txt

public class Solution {
    public static void main(String[] args) {
        try {
            String fileNameIn, fileNameOutP1, fileNameOutP2;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileNameIn = reader.readLine();
            fileNameOutP1 = reader.readLine();
            fileNameOutP2 = reader.readLine();
            reader.close();

            FileInputStream fis = new FileInputStream(fileNameIn);
            FileOutputStream fos = new FileOutputStream(fileNameOutP1);
            int halfBytes = (int) Math.ceil(1.0 * fis.available() / 2);

            for (int i = 0; i < halfBytes; i++)
                fos.write(fis.read());
            fos.close();

            fos = new FileOutputStream(fileNameOutP2);
            while (fis.available() > 0)
                fos.write(fis.read());

            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
