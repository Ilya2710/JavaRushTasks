package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Смирнов", dateFormat.parse("MAY 1 2012"));
        map.put("Иванов", dateFormat.parse("JANUARY 2 2011"));
        map.put("Петров", dateFormat.parse("FEBRUARY 3 2010"));
        map.put("Сидоров", dateFormat.parse("MARCH 4 2009"));
        map.put("Кузнецов", dateFormat.parse("APRIL 5 2008"));
        map.put("Попов", dateFormat.parse("JUNE 10 2007"));
        map.put("Стрельцов", dateFormat.parse("JULY 11 1999"));
        map.put("Коноваленко", dateFormat.parse("AUGUST 15 1988"));
        map.put("Яшин", dateFormat.parse("SEPTEMBER 20 1982"));
        map.put("Кочемасов", dateFormat.parse("OCTOBER 27 1953"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Date date = iterator.next().getValue();
            if (5 <= date.getMonth() && date.getMonth() <= 7)
                iterator.remove();
        }
    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map = createMap();
        removeAllSummerPeople(map);
    }
}
