package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o) {
        float deltaDistance = this.getDistance() - o.getDistance();
        int deltaQuality = this.getQuality() - o.getQuality();

        if (deltaDistance == 0) {
            if (deltaQuality == 0)
                return 0;
            else if (deltaQuality > 0)
                return 1;
            else
                return -1;
        } else if (deltaDistance < 0) {
            if (deltaQuality < 0)
                return 0; ////////////
            else
                return 1;
        } else {
            if (deltaQuality > 0)
                return 0; ////////////
            else
                return -1;
        }
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach1 = new Beach("First", 2, 2);
        Beach beach2 = new Beach("Second", 1, 1);

        System.out.println(beach1.compareTo(beach2));
    }
}
