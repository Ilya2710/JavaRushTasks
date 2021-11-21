package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();

        String[] strArray = string.split(" ");
//        for (String s : strArray) {
//            System.out.println(s);
//        }

        if (strArray.length < 5)
            throw new TooShortStringException();

        return strArray[1] + " " + strArray[2] + " " + strArray[3] + " " + strArray[4];
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
