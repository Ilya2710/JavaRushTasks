package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        byte[][] a3 = new byte[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3);
    }

    public static int getRectangleCount(byte[][] a) {
        List<Rectangle> list = new ArrayList<>();

        int maxX = a.length, maxY = a[0].length;

        for (int currentX = 0; currentX < maxX; currentX++) {
            for (int currentY = 0; currentY < maxY; currentY++) {
                if(a[currentX][currentY] != 0 && a[currentX][currentY] != 1)
                    throw new IllegalArgumentException();
                else if (a[currentX][currentY] == 0)
                    continue;
                else {
                    boolean needNewRectangle = true;
                    for (int i = 0; i < list.size(); i++)
                        if (list.get(i).hasPoint(currentX, currentY))
                            needNewRectangle = false;
                    if (!needNewRectangle)
                        continue;
                    else {
                        int currentX1 = currentX, currentY1 = currentY;
                        while(currentY1 < maxY && a[currentX1][currentY1] == 1)
                            currentY1++;
                        currentY1--;
                        while (currentX1 < maxX && a[currentX1][currentY1] == 1)
                            currentX1++;
                        currentX1--;
                        Rectangle rec = new Rectangle(currentX, currentY, currentX1, currentY1);
                        if (rec.isValidRectangle(a))
                            list.add(rec);
                        else
                            throw new IllegalArgumentException();
                    }
                }
            }
        }

        return list.size();
    }

    public static class Rectangle {
        int[] x = new int[2];
        int[] y = new int[2];

       Rectangle (int x0, int y0, int x1, int y1) {
            this.x[0] = x0;
            this.y[0] = y0;
            this.x[1] = x1;
            this.y[1] = y1;
        }

        public boolean hasPoint(int x, int y) {
            return this.x[0] <= x && x <= this.x[1] && this.y[0] <= y && y <= this.y[1];
        }

        public boolean isValidRectangle(byte[][] a) {
            for (int i = this.x[0]; i <= this.x[1]; i++)
                for (int j = this.y[0]; j <= this.y[1] ; j++)
                    if (a[i][j] != 1)
                        return false;
            if (0 <= this.x[0] - 1)
                for (int j = this.y[0]; j <= this.y[1] ; j++)
                    if (a[x[0]-1][j] != 0)
                        return false;
            if (this.x[1] + 1 < a.length)
                for (int j = this.y[0]; j <= this.y[1] ; j++)
                    if (a[x[1]+1][j] != 0)
                        return false;
            if (0 <= this.y[0] - 1)
                for (int i = this.x[0]; i <= this.x[1] ; i++)
                    if (a[i][y[0]-1] != 0)
                        return false;
            if (this.y[1] + 1 < a[0].length)
                for (int i = this.x[0]; i <= this.x[1] ; i++)
                    if (a[i][y[1]+1] != 0)
                        return false;
            if ((0 <= this.x[0]-1 && 0 <= this.y[0]-1                 && a[this.x[0]-1][this.y[0]-1] != 0) ||
                (0 <= this.x[0]-1 && this.y[1]+1 < a[0].length        && a[this.x[0]-1][this.y[1]+1] != 0) ||
                (this.x[1]+1 < a.length && 0 <= this.y[0]-1           && a[this.x[1]+1][this.y[0]-1] != 0) ||
                (this.x[1]+1 < a.length && this.y[1]+1 < a[0].length  && a[this.x[1]+1][this.y[1]+1] != 0))
                return false;

            return true;
        }
    }
}


