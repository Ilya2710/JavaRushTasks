package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "Ivanov");
//        map.put("country", "Ukraine");
//        map.put("city", "Kiev");
//        map.put("age", null);
//
//        getQuery(map);
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder("");

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                if (!stringBuilder.toString().equals(""))
                    stringBuilder.append(" and ");
                stringBuilder.append(entry.getKey() + " = " + "'" + entry.getValue() + "'");
            }
        }
//        System.out.println(stringBuilder);

        return stringBuilder.toString();
    }
}
