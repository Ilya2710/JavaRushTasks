package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/* 
Парсер реквестов
*/

// http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
// http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

public class Solution {
    public static void main(String[] args) {
        String url = null;
        String subString;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            url = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = new ArrayList<String>();
        String objValue = null;

        if (url != null && url.indexOf('?') >= 0) {
            subString = url.substring(url.indexOf('?') + 1);
            boolean isLastParameter = false;

            do {
                int indexOfAmpersand = subString.indexOf('&');
                String parameter;

                if (indexOfAmpersand < 0)
                    parameter = subString;
                else
                    parameter = subString.substring(0,indexOfAmpersand);

                int indexOfEqual = parameter.indexOf('=');

                if (indexOfEqual < 0)
                    list.add(parameter);
                else {
                    list.add(parameter.substring(0, indexOfEqual));
                    if (parameter.substring(0, indexOfEqual).equals("obj"))
                        objValue = parameter.substring(indexOfEqual + 1);
                }

                if (indexOfAmpersand < 0)
                    isLastParameter = true;
                else
                    subString = subString.substring(indexOfAmpersand + 1);
            } while(!isLastParameter);
        }

        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println("");

        if (objValue != null) {
            try {
                double doubleObjValue = Double.parseDouble(objValue);
                alert(doubleObjValue);
            } catch (NumberFormatException e) {
                alert(objValue);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
