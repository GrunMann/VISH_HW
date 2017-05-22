package geometry;
import static java.lang.Math.sqrt;

public class Triangle extends Shape{
    final Point a;
    final Point b;
    final Point c;

    public Triangle(Point a, Point b, Point c) throws IllegalArgumentException{
        this.a = a;
        this.b = b;
        this.c = c;
        if(getArea()==0){
            throw new IllegalArgumentException("Vertexes lies on a single line.");
        }
    }
    
    public float getPerimeter(){
        return  a.distanceTo(b) +
                b.distanceTo(c) +
                c.distanceTo(a);
    }
    public float getArea(){
        float ab= a.distanceTo(b);
        float bc= b.distanceTo(c);
        float ca= c.distanceTo(a);
        float s= (ab+bc+ca)/2f;
        return (float) sqrt(s*(s-ab)*(s-bc)*(s-ca));
    }
    
    
}
