package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat formater = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date dt = null;
        try {
            dt = formater.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int days;

        SimpleDateFormat formater2 = new SimpleDateFormat("D");
        days = Integer.parseInt(formater2.format(dt));

        if(days % 2 == 1)
            return true;
        else
            return false;
    }
}
