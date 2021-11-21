package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        String result = "";

        if (n < 0)
            result = "0";
        else if (n == 0)
            result = "1";
        else if (n <= 150){
            BigInteger res = BigInteger.valueOf(1);
            for (int i = 1; i <= n ; i++)
                res = res.multiply(BigInteger.valueOf(i));
            result = res.toString();
        }

        return result;
    }
}
