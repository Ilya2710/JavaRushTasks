package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = createHashMap();
        printHashMap(map);
    }

    public static HashMap<String, Integer> createHashMap() {
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = null;
            String enteredString = null;
            Integer enteredInteger = null;

            try {
                str = reader.readLine();
                if (str.isEmpty())
                    break;
                enteredInteger = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                    System.out.println(str + " не является целым числом");
                    continue;
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                while (true) {
                    enteredString = reader.readLine();
                    if (map.containsKey(enteredString)) {
                        System.out.println("Строка " + "\"" + enteredString + "\"" + " уже была введена");
                        continue;
                    }
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            map.put(enteredString, enteredInteger);
            if (enteredString.isEmpty())
                break;
        }

        return map;
    }

    public static void printHashMap(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> pair : map.entrySet())
            System.out.println(pair.getValue() + " " + pair.getKey());
    }
}