package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task17/task1721/F1season2020.txt
// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task17/task1721/F1season2020_remove.txt

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();

            FileInputStream fis = new FileInputStream(fileName1);
            reader = new BufferedReader(new InputStreamReader(fis));

            while (reader.ready())
                allLines.add(reader.readLine());
            reader.close();
            fis.close();

            fis = new FileInputStream(fileName2);
            reader = new BufferedReader(new InputStreamReader(fis));

            while (reader.ready())
                forRemoveLines.add(reader.readLine());
            reader.close();
            fis.close();

            Solution solution = new Solution();
            solution.joinData();

//            for (String str : allLines)
//                System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
