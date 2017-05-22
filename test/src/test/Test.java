
package test;

import java.awt.Point;


public class Test {

    private static Point a = new Point(1, 50);
    private static Point b = new Point(40, 0);
    
    
    public static void main(String[] args) {
        System.out.println(Math.abs(a.x-b.x));
        System.out.println((Math.abs(a.x-b.x)*Math.abs(a.x-b.x)));
        System.out.println(Math.sqrt(4));
        
        System.out.println(Math.hypot((Math.max(a.x, b.x)-Math.min(a.x,b.x)),(Math.max(a.y, b.y)-Math.min(a.y,b.y))));
    }
    
}
