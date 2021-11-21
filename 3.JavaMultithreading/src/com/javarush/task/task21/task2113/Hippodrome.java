package com.javarush.task.task21.task2113;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ilya2710 on 21.06.2021.
 */

public class Hippodrome {
    private List<Horse> horses;

    public static Hippodrome game;

    public static void main(String[] args) {
        List<Horse> horses = new LinkedList<>();
        horses.add(new Horse("Alpha", 3, 0));
        horses.add(new Horse("Betta", 3, 0));
        horses.add(new Horse("Gamma", 3, 0));

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses)
            horse.move();
    }

    public void print() {
        for (Horse horse : horses)
            horse.print();

        for (int i = 0; i < 10; i++)
            System.out.println();
    }

    public Horse getWinner() {
        Horse winner;

        if (horses.size() <= 0)
            return null;
        else
            winner = horses.get(0);

        for (Horse horse : horses)
            if (horse.getDistance() > winner.getDistance())
                winner = horse;

        return winner;
    }

    public void printWinner() {
        Horse winner = getWinner();
        System.out.println("Winner is " + winner.getName() + "!");
    }
}
