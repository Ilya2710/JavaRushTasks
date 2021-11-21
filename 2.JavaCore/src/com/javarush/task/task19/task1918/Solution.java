package com.javarush.task.task19.task1918;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Знакомство с тегами
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1918/HTML-файл.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1918/Регулярные выражения — Википедия.txt

public class Solution {
    public static void main(String[] args) {
        String fileName = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            while (reader.ready())
                list.add(reader.readLine());

            reader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String printHashtag = "";
        int lineHashtagBegin = 0, positionHashtagBegin = 0, lineHashtagEnd = 0, positionHashtagEnd = 0, depth = 0;

        while (lineHashtagBegin < list.size()) {
            int currentPosition = list.get(lineHashtagBegin).substring(positionHashtagBegin).indexOf("<" + args[0]);

            if (currentPosition < 0) {
                lineHashtagBegin++;
                positionHashtagBegin = 0;
                continue;
            } else
                currentPosition += list.get(lineHashtagBegin).substring(0, positionHashtagBegin).length();


            positionHashtagBegin = currentPosition;
            lineHashtagEnd = lineHashtagBegin;
            positionHashtagEnd = positionHashtagBegin + ("<" + args[0]).length();
            if (positionHashtagEnd >= list.get(lineHashtagBegin).length()) {
                lineHashtagEnd++;
                positionHashtagEnd = 0;
            }
            depth++;
            printHashtag += list.get(lineHashtagBegin).substring(positionHashtagBegin,positionHashtagEnd);
            while (depth > 0 && lineHashtagEnd < list.size()) {
                int currentPositionBegin = list.get(lineHashtagEnd).substring(positionHashtagEnd).indexOf("<" + args[0]);
                if (currentPositionBegin >= 0)
                    currentPositionBegin += list.get(lineHashtagEnd).substring(0, positionHashtagEnd).length();
                int currentPostiionEnd = list.get(lineHashtagEnd).substring(positionHashtagEnd).indexOf("</" + args[0] + ">");
                if (currentPostiionEnd >= 0)
                    currentPostiionEnd += list.get(lineHashtagEnd).substring(0, positionHashtagEnd).length();

                if (currentPositionBegin < 0 && currentPostiionEnd < 0) {
                    printHashtag += list.get(lineHashtagEnd).substring(positionHashtagEnd);
                    lineHashtagEnd++;
                    positionHashtagEnd = 0;
                    printHashtag.trim();
                    continue;
                }

                if (currentPostiionEnd >= 0 && (currentPositionBegin < 0 || currentPostiionEnd < currentPositionBegin)) {
                    printHashtag += list.get(lineHashtagEnd).substring(positionHashtagEnd, currentPostiionEnd +
                            ("</" + args[0] + ">").length());
                    positionHashtagEnd = currentPostiionEnd + ("</" + args[0] + ">").length();
                    depth--;
                    continue;
                }

                if (currentPositionBegin >= 0 && (currentPostiionEnd < 0 || currentPositionBegin < currentPostiionEnd)) {
                    printHashtag += list.get(lineHashtagEnd).substring(positionHashtagEnd, currentPositionBegin +
                            ("<" + args[0]).length());
                    positionHashtagEnd = currentPositionBegin + ("<" + args[0]).length();
                    depth++;
                    continue;
                }
            }

            System.out.println(printHashtag);
            printHashtag = "";
            positionHashtagBegin = currentPosition + ("<" + args[0]).length();
            if (positionHashtagBegin >= list.get(lineHashtagBegin).length()) {
                lineHashtagBegin++;
                positionHashtagBegin = 0;
            }
        }
    }
}
