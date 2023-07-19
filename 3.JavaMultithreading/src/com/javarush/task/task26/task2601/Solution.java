package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int median;
        if (array.length%2 == 0)
            median = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        else
            median = array[array.length / 2];


        Comparator<Integer> compareDistanceToMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (Math.abs(o1 - median) == Math.abs(o2 - median)) ? o1 - o2 :
                        Math.abs(o1 - median)  - Math.abs(o2 - median);
            }
        };

        Arrays.sort(array, compareDistanceToMedian);
        return array;
    }
}
