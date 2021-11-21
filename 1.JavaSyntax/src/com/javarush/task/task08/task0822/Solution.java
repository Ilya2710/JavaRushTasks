package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int min;
        min = array.get(0);

        for (int i = 1; i < array.size(); i++)
            if(min > array.get(i))
                min = array.get(i);

        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        int N;

        do {
            N = ReadIntNumber.readInt();
            if (N <= 0)
                System.out.println("The number must be positive");
        } while (N <= 0);

        List<Integer> list = new ArrayList<Integer>(N);

        for (int i = 0; i < N; i++)
            list.add(ReadIntNumber.readInt());

        return list;
    }
}

class ReadIntNumber {
    public static int readInt(){
        String str = "";
        int number;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try {
//                System.out.print("Введите целое число: ");
                str = reader.readLine();
                number = Integer.parseInt(str);
                return number;
            } catch (NumberFormatException e){
                System.out.println(str + " не является целым числом");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}