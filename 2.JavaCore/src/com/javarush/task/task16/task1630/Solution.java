package com.javarush.task.task16.task1630;

import java.io.*;

/* 
Последовательный вывод файлов
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task16/task1630/F1season2020_Jan.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task16/task1630/F1season2020_Feb.txt

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fileName;
        String fileContent = "";

        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        public String getFileContent() {
            return this.fileContent;
        }

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(this.fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

                while (reader.ready()) {
                    this.fileContent += reader.readLine();
                    if (reader.ready())
                        this.fileContent += " ";
                }

                fis.close();
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
