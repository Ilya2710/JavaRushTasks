package com.javarush.task.task20.task2025;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/* 
Алгоритмы-числа
*/

// Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.
// https://acmp.ru/article.asp?id_text=198

public class Solution {
    static long[] degree10 = new long[19];
    static long[][] degree = new long[10][20];

    static {
        for (int i = 0; i < degree10.length; i++) {
            degree10[i] = 1;
            for (int j = 0; j < i; j++)
                degree10[i] *= 10;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                degree[i][j] = 1;
                for (int k = 0; k < j; k++) {
                    degree[i][j] *= i;
                }
            }
        }
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        if(N <= 0 )
            return result;

        Set<Long> set = new HashSet<Long>();
        int[] digits = new int[19];

        Arrays.fill(digits, 0);
        int M = 1, currentPostion = 0;

        final int BOUND = countDigits(N) + 1;

        while (M < BOUND) {
//            System.out.println(Arrays.toString(digits));
            while (true) {
                digits[currentPostion]++;
                if (digits[currentPostion] < 10)
                    break;
                else {
                    currentPostion++;
                    if (M == currentPostion)
                        M++;
                    if (currentPostion == digits.length)
                        break;
                }
            }
            if (currentPostion == digits.length)
                continue;
            if (currentPostion > 0) {
                int temp = digits[currentPostion];
                while (currentPostion > 0) {
                    currentPostion--;
                    digits[currentPostion] = temp;
                }
            }

            for (int indexM = M; indexM < BOUND; indexM++) {
                long digitsInDegreeNumber = digitsInDegree(digits, indexM);
                if (digitsInDegreeNumber < 0)
                    continue;
                if (indexM != countDigits(digitsInDegreeNumber))
                    continue;
                if(digitsInDegreeNumber < N && isArmstrongnumber(digits, digitsInDegreeNumber)) {
                    set.add(digitsInDegreeNumber);
                }
            }
        }

        result = new long[set.size()];
        Iterator iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            result[i++] = (Long) iterator.next();
        }

        Arrays.sort(result);

        return result;
    }

    public static long digitsInDegree(int[] digits, int M) {
        long result = 0L;
        for (int i = 0; i < M; i++) {
            result += degree[digits[i]][M];
            if(result <= 0)
                return  -1L;
        }

        return result;
    }

    public static boolean isArmstrongnumber(int[] digits, long digitsInDegreeNumber) {
        int[] digits1 = new int[digits.length];
        for (int i = 0; digitsInDegreeNumber > 0; i++) {
            digits1[i] = (int) (digitsInDegreeNumber % 10);
            digitsInDegreeNumber /= 10;
        }

        Arrays.sort(digits1);
        reverseArray(digits1);

        for (int i = 0; i < digits.length; i++)
            if (digits[i] != digits1[i])
                return false;

        return true;
    }

    public static void reverseArray (int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static int countDigits(long number) {
        int result = 1;
        while (true) {
            number /= 10;
            if(number == 0)
                break;
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
       long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
//        long[] arr = getNumbers(Long.MAX_VALUE);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
