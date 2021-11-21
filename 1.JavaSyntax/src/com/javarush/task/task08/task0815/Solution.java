package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
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

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int counter = 0;

        Collection<String> list = map.values();

        for (String str: list)
            if(str.equals(name))
                counter++;

        return counter;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int counter = 0;

        Set<String> set = map.keySet();

        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext())
            if(iterator.next().equals(lastName))
                counter++;

        return counter;
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        getCountTheSameFirstName(map, "Александр");
        getCountTheSameLastName(map, "Бармашов");
//        System.out.println(getCountTheSameFirstName(map, "Александр"));
//        System.out.println(getCountTheSameLastName(map, "Бармашов"));
    }
}
