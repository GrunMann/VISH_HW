package shapes;

import static java.lang.Math.sqrt;
import shapes.exceptions.UnsupportedArgumentExceptin; 

public class Triangle extends Shape {

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) throws UnsupportedArgumentExceptin {
        this.a = a;
        this.b = b;
        this.c = c;
        if (getArea () == 0) {
            throw new UnsupportedArgumentExceptin ("Points lie on the same line"); 
        }
    }

    public float getPerimeter() {
        return a.distanceTo(b)
                + b.distanceTo(c)
                + c.distanceTo(a);
    }

    public float getArea() {
        float   ab = a.distanceTo(b),
                bc = b.distanceTo(c),
                ac = c.distanceTo(a),
                s = (ab + bc + ac) / 2f;
        return (float) sqrt(s * (s - ab) * (s - bc) * (s - ac));
    }
}
