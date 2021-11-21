package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Ferrari");
        list.add("Mercedes");
        list.add("Red Bull");
        list.add("McLaren");
        list.add("Renault");

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
