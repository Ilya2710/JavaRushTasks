package com.javarush.custom.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ilya2710 on 07.10.2020.
 */
public class ReadIntNumber {
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
