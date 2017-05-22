package geometry;
import static java.lang.Math.sqrt;
public class Point {

    final float x;
    final float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float distanceTo(Point point) {
        float dx = x - point.x;
        float dy = y - point.y;
        return (float) sqrt(dx*dx+dy*dy);
    }
    public float getX(){return x;}
    public float gety(){return y;}
    
}
