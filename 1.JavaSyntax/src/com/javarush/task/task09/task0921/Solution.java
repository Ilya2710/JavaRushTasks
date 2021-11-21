package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        String str = "";
        int number;
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try {
//                System.out.print("Введите целое число: ");
                str = reader.readLine();
                number = Integer.parseInt(str);
                list.add(number);
            } catch (NumberFormatException e){
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
