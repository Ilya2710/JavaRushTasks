package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2209/cities.txt

public class Solution {
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

        StringBuilder result = getLine(inputStringArray);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder("");

        List<String> listFromArray = Arrays.asList(words);
        List<String> list;
        StringBuilder result = new StringBuilder();;

//        System.out.println(list);

        int firstWordIndex = 0;
        boolean isFinished = false;

        while (!isFinished) {
            if (firstWordIndex >= listFromArray.size()) {
                System.out.println("Wrong set of words");
                break;
            }

            list = new ArrayList<String>();

            for (int i = 0; i < listFromArray.size(); i++)
                list.add(listFromArray.get(i));

            result = new StringBuilder();
            String lastLetter = "";

            int strSize = list.get(firstWordIndex).length();
            lastLetter = list.get(firstWordIndex).substring(strSize - 1, strSize);
            result.append(list.get(firstWordIndex));
            list.remove(firstWordIndex);

            boolean isNextWordFound = true;

            while(list.size() > 0 && isNextWordFound) {
                isNextWordFound = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).substring(0,1).equalsIgnoreCase(lastLetter)) {
                        int strSize2 = list.get(i).length();
                        lastLetter = list.get(i).substring(strSize2 - 1, strSize2);
                        result.append(" " + list.get(i));
                        list.remove(i);
                        isNextWordFound = true;
                        break;
                    }
                }
                if (!isNextWordFound) {
                    firstWordIndex++;
                } else
                    if (list.size() == 0)
                        isFinished = true;
            }
        }

        return result;
    }
}
