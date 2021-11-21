package com.javarush.task.task18.task1803;

import javafx.util.Pair;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Самые частые байты
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1803/F1season2020.txt

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = null;
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();

            FileInputStream fis = null;
            fis = new FileInputStream(fileName);

            while (fis.available() > 0) {
                Integer currentByte = fis.read();
                boolean isChanged = false;
                for (int i = 0; i < list.size(); i++) {
                    if (currentByte.equals(list.get(i).getKey())) {
                        Integer currentKey = list.get(i).getKey();
                        Integer currentValue = list.get(i).getValue();
                        list.set(i, new Pair<Integer, Integer>(currentKey, currentValue + 1));
                        isChanged = true;
                        break;
                    }
                }
                if (isChanged)
                    continue;
                list.add(new Pair<Integer, Integer>(currentByte, 1));
            }
            fis.close();

            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).getValue() > list.get(j).getValue()) {
                        Pair<Integer, Integer> temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                    }
                }
            }

            for (int i = list.size() - 1; list.get(i).getValue().equals(list.get(list.size()-1).getValue()); i--) {
                System.out.print(list.get(i).getKey() + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
