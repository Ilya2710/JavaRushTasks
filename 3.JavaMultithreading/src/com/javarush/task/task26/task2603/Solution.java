package com.javarush.task.task26.task2603;

import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T>[] comparators;

        CustomizedComparator(Comparator<T>...vararg) {
            this.comparators = vararg;
        }

        public int compare(T t1, T t2) {
            int result = 0;

            for (int i = 0; i < comparators.length; i++) {
                int intermediate_result = comparators[i].compare(t1, t2);

                if (intermediate_result == 0)
                    continue;
                else {
                    result =  intermediate_result;
                    break;
                }
            }

            return result;
        }
    }
}
