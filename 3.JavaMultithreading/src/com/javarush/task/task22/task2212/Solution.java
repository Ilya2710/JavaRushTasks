package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null)
            return false;

        // 5
        if(!telNumber.matches("[\\d\\+\\(\\)]*"))
            return false;

        // 1, 2
        String tempTelNumber = telNumber.replaceAll("[\\(\\)]", "");
        if (!tempTelNumber.matches("^\\+[\\d]{12}") && !tempTelNumber.matches("\\d{10}"))
            return false;

        // 3, 4, 6
        if (!telNumber.matches("^[\\+]?\\d{0,11}(\\(\\d\\d\\d\\))?\\d{0,11}\\d$"))
            return false;

        return true;
    }

    public static void main(String[] args) {
        Map<String, Boolean> phones = new HashMap<String, Boolean>();
        phones.put("+380501234567", true);      // Example
        phones.put("+38(050)1234567", true);    // Example
        phones.put("(050)1234567", true);       // Example
        phones.put("0(501)234567", true);       // Example
        phones.put("+38)050(1234567", false);   // Example
        phones.put("+38(050)123-45-67", false); // Example
        phones.put("050ххх4567", false);        // Example
        phones.put("050123456", false);         // Example
        phones.put("(0)501234567", false);      // Example

        phones.put("+38050123456", false);      // 1
        phones.put("+3805012345678", false);    // 1
        phones.put("(050)123456", false);       // 2
        phones.put("(050)12345678", false);     // 2
        phones.put("050123456", false);         // 2
        phones.put("05012345678", false);       // 2
        phones.put("0(501)2(345)67", false);    // 3
        phones.put("0(50)1234567", false);      // 4
        phones.put("0(5012)34567", false);      // 4
        phones.put("(050)123a4567", false);     // 5
        phones.put("(050)123a567", false);      // 5
        phones.put("(050)123a45678", false);    // 5
        phones.put("+38(050)123a4567", false);  // 5
        phones.put("+38(050)123a567", false);   // 5
        phones.put("+38(050)123a45678", false); // 5
        phones.put("+38(050)123456x", false);   // 6
        phones.put("+38(050)1234567x", false);  // 6
        phones.put("(050)123456x", false);      // 6
        phones.put("(050)1234567x", false);     // 6

        for (Map.Entry<String, Boolean> entry : phones.entrySet())
            System.out.println(entry.getKey() + ":\t" + entry.getValue() + ":\t" + checkTelNumber(entry.getKey()));

    }
}
