package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

// -e C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/F1season2020_e_in.txt C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/F1season2020_e_out.txt
// -d C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/F1season2020_d_in.txt C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/F1season2020_d_out.txt

public class Solution {
    public static void main(String[] args) {
        if (args[0].equals("-e") && args[1] != null && args[2] != null)
            crypt(args[1], args[2], true);
        else if(args[0].equals("-d") && args[1] != null && args[2] != null)
            crypt(args[1], args[2], false);
    }

    public static void crypt(String fileNameIn, String fileNameOut, boolean isEncryption) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileNameIn));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOut));

            while (reader.ready()) {
                int readChar = reader.read();
                if (isEncryption)
                    writer.write(encrypt(readChar));
                else
                    writer.write(decrypt(readChar));
            }

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int encrypt(int c) {
        return c + 3;
    }

    public static int decrypt(int c) {
        return c - 3;
    }
}