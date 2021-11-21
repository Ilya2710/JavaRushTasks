package com.javarush.task.task18.task1821;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Встречаемость символов
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1821/MSchumacher.txt

public class Solution {
    public static void main(String[] args) {
        try {
            int[] letters = new int[65536];
            FileReader fileReader = new FileReader(args[0]);

//            for(int n = 0; n < 5; n++) {
            while (fileReader.ready()) {
                int symbol = fileReader.read();
//                System.out.println(symbol + " " + ((char) symbol));
                letters[symbol]++;
            }

            for (int i = 0; i < letters.length; i++) {
                if (letters[i] != 0)
                    System.out.print(((char)i) + " " + letters[i] + "\n");
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
