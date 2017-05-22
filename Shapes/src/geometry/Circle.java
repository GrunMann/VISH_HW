package geometry;
import static java.lang.Math.PI;

public class Circle extends Shape{
    float radius;

    public Circle(float radius) throws IllegalArgumentException{
        if (!isValidRadius(radius)){
            throw new IllegalArgumentException("Illegal radius given : "+ radius + "!");
        }
        this.radius = radius;
    }
    
    private static boolean isValidRadius(float radius){
        return radius > 0;
    }
    
    public float getLength(){
        return (float)(2.*PI*radius);
    }
    
    public float getPerimeter(){
        return getLength();
    }
    
    public float getArea(){
        return (float)(PI*radius*radius);
    }
    
    public float getRadius(){
        return radius;
    }
    
}
