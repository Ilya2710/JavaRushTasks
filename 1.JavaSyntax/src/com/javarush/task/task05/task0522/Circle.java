package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

import java.awt.image.CropImageFilter;

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(){
        this(5, 5, 3);
    }

    public Circle(int x, int y){
        this(x, y, 3);
    }

    public Circle(Circle circle){
        this(circle.x, circle.y, circle.radius);
    }

    public static void main(String[] args) {

    }
}