package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1825/F1season2020.txt.part1
// ...
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1825/F1season2020.txt.part12

public class Solution {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        String fileNameWhole = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName;
            while (!(fileName = reader.readLine()).equals("end")) {
                if (fileNameWhole.equals("")) {
                    if (fileName.lastIndexOf(".part") == -1) {
                        System.out.println("Wrong name of file");
                        continue;
                    }
                    fileNameWhole = fileName.substring(0, fileName.lastIndexOf(".part"));
                }
                else if ((fileName.lastIndexOf(".part") == -1) || (!fileNameWhole.equals(fileName.substring(0, fileName.lastIndexOf(".part"))))) {
                    System.out.println("Wrong name of file");
                    continue;
                }

                String partNumberStr = fileName.substring(fileName.lastIndexOf(".part") + 5, fileName.length());
                int partNumberInt = -1;
                try {
                    partNumberInt = Integer.parseInt(partNumberStr);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong name of file");
                    continue;
                }
                map.put(partNumberInt, fileName);
            }
            reader.close();

            FileOutputStream fileOutputStream = new FileOutputStream(fileNameWhole);

            for (int i = 1; i <= map.size(); i++) {
                if (map.get(i) == null) {
                    System.out.println("Not enough parts of file: " + i);
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(map.get(i));

                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);

                fileInputStream.close();
            }

            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
