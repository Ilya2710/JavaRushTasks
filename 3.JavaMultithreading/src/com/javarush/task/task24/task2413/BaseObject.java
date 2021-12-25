package com.javarush.task.task24.task2413;

/**
 * Created by Ilya2710 on 18.12.2021.
 */

public abstract class BaseObject {
    protected double x, y, radius;

    public BaseObject(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public abstract void draw(Canvas canvas);

    public abstract void move();

    public boolean intersects(BaseObject o) {
        double distance;
        distance = Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2));

        if (distance <= Math.max(radius, o.radius))
            return true;
        else
            return false;
    }
}
