package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1810/F1season2020_1.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1810/F1season2020_2.txt

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try {
            String fileName;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                fileName = reader.readLine();
                FileInputStream fis = new FileInputStream(fileName);
                int fileSize = fis.available();
                fis.close();
                if (fileSize < 1000) {
                    reader.close();
                    throw new DownloadException();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DownloadException extends Exception {

    }
}
