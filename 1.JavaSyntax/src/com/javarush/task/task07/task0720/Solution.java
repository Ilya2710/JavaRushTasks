package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        N = readInt();
        M = readInt();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++)
            list.add(reader.readLine());

        for (int i = 0; i < M; i++)
            list.add(list.remove(0));

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
