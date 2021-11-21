package com.javarush.task.task18.task1823;

import com.sun.org.apache.regexp.internal.RE;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Нити и байты
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1823/F1season2020.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1823/MSchumacher.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1823/Table.txt

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        List<ReadThread> list = new ArrayList<>();

        String str;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (!(str = reader.readLine()).equals("exit")) {
                ReadThread readThread = new ReadThread(str);
                list.add(readThread);
                readThread.start();
            }
            reader.close();

            try {
                for (int i = 0; i < list.size(); i++)
                    list.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            for (Map.Entry<String, Integer> entry: resultMap.entrySet()) {
//                System.out.println(entry.getKey());
//                System.out.println(entry.getValue());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            int[] bytesArray = new int[256];

            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0)
                    bytesArray[fileInputStream.read()]++;
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            int maxByte = -1, index = -1;
            for (int i = 0; i < bytesArray.length; i++)
                if (maxByte < bytesArray[i]) {
                    maxByte = bytesArray[i];
                    index = i;
                }
            synchronized (resultMap) {
                resultMap.put(fileName, index);
            }
        }
    }
}
