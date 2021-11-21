package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String NUMBERS = "0123456789";
        String DOT = ".";
        String MINUS = "-";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString;

        while (!((inputString = reader.readLine()).equals("exit"))){
            if (inputString.contains(DOT) && consistOf(inputString, NUMBERS + DOT + MINUS)) {
                try {
                    Double doubleValue = Double.parseDouble(inputString);
                    print(doubleValue);
                    continue;
                } catch (NumberFormatException e) {
                }
            }
            if (consistOf(inputString, MINUS + NUMBERS)){
                try {
                    short shortValue = Short.parseShort(inputString);
                    if (shortValue > 0 && shortValue < 128) {
                        print(shortValue);
                        continue;
                    }
                } catch (NumberFormatException e) {
                }
                try {
                    Integer integerValue = Integer.parseInt(inputString);
                    if (integerValue <= 0 || integerValue >= 128) {
                        print(integerValue);
                        continue;
                    }
                } catch (NumberFormatException e) {
                }
            }

            print(inputString);
        }
        reader.close();
    }
    
    public static boolean consistOf(String firstValue, String secondValue) {
        char[] firstValueCharArray  = firstValue.toCharArray();
        char[] secondValueCharArray = secondValue.toCharArray();

        for (int i = 0; i < firstValueCharArray.length; i++) {
            boolean result = false;
            for (int j = 0; j < secondValueCharArray.length; j++) {
                if (firstValueCharArray[i] == secondValueCharArray[j]) {
                    result = true;
                    break;
                }
            }
            if (!result)
                return false;
        }

        return true;
    } 

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
