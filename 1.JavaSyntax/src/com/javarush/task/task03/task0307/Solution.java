package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        Zerg zerg01 = new Zerg();
        Zerg zerg02 = new Zerg();
        Zerg zerg03 = new Zerg();
        Zerg zerg04 = new Zerg();
        Zerg zerg05 = new Zerg();

        zerg01.name  = "Zerg01";
        zerg02.name  = "Zerg02";
        zerg03.name  = "Zerg03";
        zerg04.name  = "Zerg04";
        zerg05.name  = "Zerg05";

        Protoss protoss01 = new Protoss();
        Protoss protoss02 = new Protoss();
        Protoss protoss03 = new Protoss();

        protoss01.name = "Protoss01";
        protoss02.name = "Protoss02";
        protoss03.name = "Protoss03";

        Terran terran01 = new Terran();
        Terran terran02 = new Terran();
        Terran terran03 = new Terran();
        Terran terran04 = new Terran();

        terran01.name = "Terran01";
        terran02.name = "Terran02";
        terran03.name = "Terran03";
        terran04.name = "Terran04";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
