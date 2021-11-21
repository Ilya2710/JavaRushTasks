package com.javarush.task.task14.task1417;

/**
 * Created by Ilya2710 on 02.02.2021.
 */

public class USD extends Money {
    public USD(double amount) {
        super(amount);
    }

    public String getCurrencyName() {
        return "USD";
    }
}
