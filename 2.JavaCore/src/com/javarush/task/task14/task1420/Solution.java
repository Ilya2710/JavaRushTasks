package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        int number1 = 0, number2 = 0;

//        try {
            str = reader.readLine();
            number1 = Integer.parseInt(str);
            if (number1 <= 0)
                throw new Exception();
            str = reader.readLine();
            number2 = Integer.parseInt(str);
            if (number2 <= 0)
                throw new Exception();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return;
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            return;
//        }
        reader.close();

        int divisor = 1;

        for (int i = 2; i <=  number1 && i <= number2; i++) {
            if (number1 % i == 0 && number2 % i == 0)
                divisor = i;
        }

        System.out.println(divisor);
    }
}
