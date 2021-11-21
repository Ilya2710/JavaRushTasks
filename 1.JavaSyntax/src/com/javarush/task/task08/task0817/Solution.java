package com.javarush.task.task08.task0817;

import java.lang.reflect.Array;
import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Балкин","Дмитрий");
        map.put("Бармашов","Алексей");
        map.put("Барякшев","Сергей");
        map.put("Блажков","Антон");
        map.put("Кошелев","Станислав");
        map.put("Кучин","Александр");
        map.put("Лунев","Олег");
        map.put("Новиков","Александр");
        map.put("Помаскин","Георгий");
        map.put("Столяров","Андрей");

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copy = new HashMap<>(map);
        String[] array = copy.values().toArray(new String[0]);

        Set<String> set = new HashSet<String>();

        for (int i = 0; i < array.length - 1; i++)
            for (int j = i + 1; j < array.length; j++)
                if(array[i].equals(array[j]))
                    set.add(array[i]);

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext())
            removeItemFromMapByValue(map, iterator.next());
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);

//        for(Map.Entry<String, String> pair : map.entrySet())
//            System.out.println(pair.getKey() + " - " + pair.getValue());
    }
}
