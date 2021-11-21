package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer>  list = new ArrayList<Integer>();
        ArrayList<Integer>  listDividedByThree = new ArrayList<Integer>();
        ArrayList<Integer>  listDevidedByTwo = new ArrayList<Integer>();
        ArrayList<Integer>  listDividedByOther = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++)
            list.add(readInt());

        for (Integer integer : list) {
            if(integer % 3 == 0)
                listDividedByThree.add(integer);
            if(integer % 2 == 0)
                listDevidedByTwo.add(integer);
            if (integer % 3 != 0 && integer % 2 != 0)
                listDividedByOther.add(integer);
        }

        printList(list);
        printList(listDividedByThree);
        printList(listDevidedByTwo);
        printList(listDividedByOther);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

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
