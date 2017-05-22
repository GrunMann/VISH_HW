package main;

import Shapes.Point;

public class Application {

    public static void main(String[] args) {
        
        Point a = new Point(2, 1);
        Point b = new Point(1, 2);
        float d = a.distanceTo(b);
        System.out.println(d);
    }
    
}
