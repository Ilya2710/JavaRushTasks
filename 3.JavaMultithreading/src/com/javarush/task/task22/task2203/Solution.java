package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();

        int beginIndex, endIndex;

        beginIndex = string.indexOf('\t');
        if (beginIndex < 0 || beginIndex == string.length() - 1)
            throw new TooShortStringException();

        endIndex = string.substring(beginIndex + 1).indexOf('\t');
        if (endIndex < 0)
            throw new TooShortStringException();

        return string.substring(beginIndex + 1, beginIndex + 1 + endIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
