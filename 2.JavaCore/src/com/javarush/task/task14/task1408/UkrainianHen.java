package com.javarush.task.task14.task1408;

/**
 * Created by Ilya2710 on 30.01.2021.
 */

public class UkrainianHen extends  Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 1;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
