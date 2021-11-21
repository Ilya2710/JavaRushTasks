package com.javarush.task.task15.task1530;

/**
 * Created by Ilya2710 on 10.02.2021.
 */

public abstract class DrinkMaker {
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
