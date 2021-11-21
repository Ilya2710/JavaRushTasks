package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1916/File1.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1916/File2.txt

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        String fileName1 = "", fileName2 = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader1 = new FileReader(fileName1);
            FileReader fileReader2 = new FileReader(fileName2);
            BufferedReader reader1 = new BufferedReader(fileReader1);
            BufferedReader reader2 = new BufferedReader(fileReader2);

            String currentLine1 = null, currentLine2 = null, nextLine1 = null, nextLine2 = null;
            while (true) {
                if (currentLine1 == null)
                    currentLine1 = reader1.readLine();
                if (currentLine2 == null)
                    currentLine2 = reader2.readLine();

                if (currentLine1 == null && currentLine2 == null)
                    break;
                else if (currentLine1 != null && currentLine2 == null) {
                    lines.add(new LineItem(Type.REMOVED, currentLine1));
                    currentLine1 = null;
                    continue;
                } else if (currentLine1 == null && currentLine2 != null) {
                    lines.add(new LineItem(Type.ADDED, currentLine2));
                    currentLine2 = null;
                    continue;
                }

                if (currentLine1.equals(currentLine2)) {
                    lines.add(new LineItem(Type.SAME, currentLine2));
                    currentLine1 = null;
                    currentLine2 = null;
                    continue;
                } else {
                    nextLine1 = reader1.readLine();
                    nextLine2 = reader2.readLine();

                    if (nextLine1 == null && nextLine2 ==  null)
                        System.out.println("Imposible!");
                    else if (nextLine2 != null && currentLine1.equals(nextLine2)) {
                        lines.add(new LineItem(Type.ADDED, currentLine2));
                        lines.add(new LineItem(Type.SAME, nextLine2));
                        if (nextLine1 == null)
                            currentLine1 = null;
                        else
                            currentLine1 = nextLine1;
                        currentLine2 = null;
                        continue;
                    } else if (nextLine1 != null && currentLine2.equals(nextLine1)) {
                        lines.add(new LineItem(Type.REMOVED, currentLine1));
                        lines.add(new LineItem(Type.SAME, currentLine2));
                        currentLine1 = null;
                        if (nextLine2 == null)
                            currentLine2 = null;
                        else
                            currentLine2 = nextLine2;
                        continue;
                    } else if ((nextLine1 == null && !currentLine1.equals(nextLine2)) ||
                            (nextLine2 == null && !currentLine2.equals(nextLine1)))
                        System.out.println("Imposible!");
                }
            }

            reader1.close();
            reader2.close();
            fileReader1.close();
            fileReader2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (LineItem lineItem : lines)
//            System.out.println(lineItem.type + " " + lineItem.line);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
