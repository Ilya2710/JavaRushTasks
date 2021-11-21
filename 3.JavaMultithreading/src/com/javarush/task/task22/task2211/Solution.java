package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2211/Windows-1251.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2211/UTF-8.txt

public class Solution {
    public static void main(String[] args) throws IOException {
       FileInputStream fis = new FileInputStream(args[0]);
       byte[] buffer = new byte[10000];
       fis.read(buffer);
       fis.close();

       Charset windows1251 = Charset.forName("Windows-1251");
       Charset utf8 = Charset.forName("UTF-8");

       String s = new String(buffer, windows1251);
       buffer = s.getBytes(utf8);

       FileOutputStream fos = new FileOutputStream(args[1]);
       fos.write(buffer);
       fos.close();
    }
}
