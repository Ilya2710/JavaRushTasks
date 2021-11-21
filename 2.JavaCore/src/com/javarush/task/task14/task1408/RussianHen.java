package com.javarush.task.task14.task1408;

/**
 * Created by Ilya2710 on 30.01.2021.
 */

public class RussianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
