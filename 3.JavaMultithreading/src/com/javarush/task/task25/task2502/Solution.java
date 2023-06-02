package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels = new ArrayList<Wheel>();
            String[] array = loadWheelNamesFromDB();
            if (array == null) throw new IllegalArgumentException();
            if (array.length != 4) throw new IllegalArgumentException();

            try {
                for (int i = 0; i < array.length; i++)
                    wheels.add(Wheel.valueOf(array[i]));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
