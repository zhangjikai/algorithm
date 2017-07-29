package com.zhangjikai.pinduoduo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhangjk on 2017/7/12.
 */
public class Two {

    static class Point {
        double a;
        double b;

        public Point(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public static double calRange(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length == 1) {
            return Math.abs(points[0].a - points[0].b);
        }

        for (Point point : points) {
            double tmp;
            if (point.a > point.b) {
                tmp = point.a;
                point.b = point.a;
                point.a = tmp;
            }
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.a > o2.a) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        Point point;
        double start = points[0].a, end = points[0].b;
        double total = 0;
        for (int i = 1; i < points.length; i++) {

            point = points[i];
            if (point.a < end) {
                end = point.b;
            } else {
                total += end - start;
                start = point.a;
                end = point.b;
            }
        }
        total += end - start;

        return total;
    }

    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[0] = new Point(1, 2);
        points[1] = new Point(2, 7);
        points[2] = new Point(3, 7);
        System.out.println(calRange(points));
    }

}
