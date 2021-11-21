package com.javarush.task.task14.task1421;

/**
 * Created by Ilya2710 on 06.02.2021.
 */

public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return instance;
    }
}
