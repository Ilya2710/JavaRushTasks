package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1923/Numbers_in.txt C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1923/Numbers_out.txt

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(args[0]);
            FileWriter fileWriter = new FileWriter(args[1]);
            BufferedReader reader = new BufferedReader(fileReader);

            while (reader.ready()) {
                String line = reader.readLine();
                String[] strArray = line.split(" ");
                for (String str : strArray) {
                    char[] characters = str.toCharArray();
                    for (int i = 0; i < characters.length; i++) {
                        if (Character.isDigit(characters[i])) {
                            fileWriter.write(str + " ");
                            break;
                        }
                    }
                }
            }

            reader.close();
            fileReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
