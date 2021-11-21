package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1919/Salaries.txt

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> salaries = new TreeMap<>();
        
        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(fileReader);
            
            while (reader.ready()) {
                String line = reader.readLine();
                String[] str = line.split(" ");
                double sal = Double.parseDouble(str[1]);

                if (salaries.containsKey(str[0]))
                    salaries.replace(str[0], salaries.get(str[0]) + sal);
                else
                    salaries.put(str[0], sal);
            }
            
            reader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Double> salary : salaries.entrySet()) {
            System.out.println(salary.getKey() + " " + salary.getValue());
        }
    }
}
