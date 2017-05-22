package shapes;
import static java.lang.Math.sqrt; 

public class Point {
private final float x; 
private final float y; 

public Point (float x, float y) {
    this. x =x;
    this. y =y;
}
 
public float getX (){ 
    return x; 
}
public float getY () { 
    return y; 
}
public float distanceTo (Point point) { 
    float dx = x - point.x;
    float dy = y - point.y; 
    return (float) sqrt (dx * dx + dy * dy); 
}

}
