package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Балкин",100);
        map.put("Бармашов",200);
        map.put("Барякшев",300);
        map.put("Блажков",400);
        map.put("Кошелев",500);
        map.put("Кучин",600);
        map.put("Лунев",700);
        map.put("Новиков",800);
        map.put("Помаскин",900);
        map.put("Столяров",1000);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> copy = new HashMap<String, Integer>(map);
        for(Map.Entry<String, Integer> pair : copy.entrySet())
            if(pair.getValue() < 500)
                map.remove(pair.getKey());
    }

    public static void main(String[] args) {
        Map<String, Integer> map = createMap();
        removeItemFromMap(map);

//        for(Map.Entry<String, Integer> pair : map.entrySet())
//            System.out.println(pair.getKey() + " - " + pair.getValue());
    }
}