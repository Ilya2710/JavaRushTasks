package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> people = new HashMap<String, String>();

        people.put("Иванов", "Василий");
        people.put("Иванов", "Роман");
        people.put("Петров", "Василий");
        people.put("Сидоров", "Илья");
        people.put("Смирнов", "Артём");
        people.put("Кузнецов", "Геннадий");
        people.put("Горшков", "Сергей");
        people.put("Фёдоров", "Михаил");
        people.put("Блинов", "Сергей");
        people.put("Козлов", "Александр");

        return people;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
