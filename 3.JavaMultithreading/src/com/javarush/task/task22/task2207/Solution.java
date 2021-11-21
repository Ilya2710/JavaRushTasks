package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2207/invert_words.txt

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        String fileName = "";
        StringBuilder inputStringBuilder = new StringBuilder("");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();

            FileReader fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);

            while (reader.ready())
                inputStringBuilder.append(reader.readLine() + " ");

            fileReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputString = inputStringBuilder.toString().trim();
        String[] inputStringArray = inputString.split(" ");

        for (int i = 0; i < inputStringArray.length - 1; i++) {
            if (inputStringArray[i] == null)
                continue;
            for (int j = i + 1; j < inputStringArray.length; j++) {
                if (inputStringArray[j] == null)
                    continue;
                if ((new StringBuilder(inputStringArray[i])).reverse().toString().equals(inputStringArray[j])) {
                    Pair newPair;
                    if (inputStringArray[i].compareTo(inputStringArray[j]) <= 0)
                        newPair = new Pair(inputStringArray[i], inputStringArray[j]);
                    else
                        newPair = new Pair(inputStringArray[j], inputStringArray[i]);

                    result.add(newPair);
                    inputStringArray[i] = null;
                    inputStringArray[j] = null;
                    break;
                }
            }
        }

            if (result.size() > 0)
                for (Pair pair : result)
                    System.out.println(pair);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
            this.first = "";
            this.second = "";
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
