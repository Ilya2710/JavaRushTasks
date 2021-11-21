package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> listInteger = new ArrayList<Integer>();

        fillIntegerList(listInteger, 10);
        System.out.println(findMaxSequenceLength(listInteger));
    }

    public static void fillIntegerList(List list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(readInt());
        }
    }

    public static int findMaxSequenceLength(List listInteger) {

        if(listInteger.size() == 0)
            return 0;

        int currentSequnceLength = 1, maxSequenceLength= 1;
        int prevNumber = (int)listInteger.get(0), currentNumber;

        for (int i = 1; i < listInteger.size(); i++) {
            currentNumber = (int) listInteger.get(i);

            if (prevNumber == currentNumber){
                currentSequnceLength++;
                if (currentSequnceLength > maxSequenceLength)
                    maxSequenceLength = currentSequnceLength;
            } else {
                currentSequnceLength = 1;
                prevNumber = currentNumber;
            }
        }

        return maxSequenceLength;
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