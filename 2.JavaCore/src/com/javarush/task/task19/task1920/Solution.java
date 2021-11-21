package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

// C:/Projects/JavaRushTasks/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1920/Salaries.txt

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> salaries = new TreeMap<>();

        double maxSalary = -1;

        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(fileReader);

            while (reader.ready()) {
                String line = reader.readLine();
                String[] str = line.split(" ");
                double sal = Double.parseDouble(str[1]);

                if (salaries.containsKey(str[0])) {
                    if (maxSalary < salaries.get(str[0]) + sal)
                        maxSalary = salaries.get(str[0]) + sal;
                    salaries.replace(str[0], salaries.get(str[0]) + sal);
                }
                else {
                    if (maxSalary < sal)
                        maxSalary = sal;
                    salaries.put(str[0], sal);
                }
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

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Double> salary : salaries.entrySet()) {
            if (salary.getValue() == maxSalary)
            list.add(salary.getKey());
        }

        Collections.sort(list);

        for (String str : list)
            System.out.println(str);

//        for (Map.Entry<String, Double> salary : salaries.entrySet()) {
//            System.out.println(salary.getKey() + " " + salary.getValue());
//        }
    }
}
