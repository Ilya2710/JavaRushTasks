package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<String>(12);
        list.add( 0, "January");
        list.add( 1, "February");
        list.add( 2, "March");
        list.add( 3, "April");
        list.add( 4, "May");
        list.add( 5, "June");
        list.add( 6, "July");
        list.add( 7, "August");
        list.add( 8, "September");
        list.add( 9, "October");
        list.add(10, "November");
        list.add(11, "December");

//        System.out.println(list);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String monthStr;
        int monthInt = -1;
        boolean isAMonth = false;

        do {
            monthStr = reader.readLine();
            for (int i = 0; i < list.size(); i++)
                if(list.get(i).toUpperCase().equals(monthStr.toUpperCase())){
                    monthInt = i;
                    isAMonth = true;
                    break;
                }

            if(!isAMonth)
                System.out.println(monthStr + " is not a month");
        } while(!isAMonth);

        System.out.println(list.get(monthInt) + " is the " + (monthInt + 1) + " month" );
    }
}
