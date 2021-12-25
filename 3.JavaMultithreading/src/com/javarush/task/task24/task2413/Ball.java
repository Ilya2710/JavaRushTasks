package com.javarush.task.task24.task2413;

/**
 * Created by Ilya2710 on 18.12.2021.
 */

public class Ball extends BaseObject {
    private double speed, direction, dx, dy;
    private boolean isFrozen;

    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        this.isFrozen = true;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    @Override
    public void move() {
        if(!isFrozen) {
            x += dx;
            y += dy;
        }
    }

    void start() {
        this.isFrozen = false;
    }

    void checkRebound(int minx, int maxx, int miny, int maxy) {

    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }
}
