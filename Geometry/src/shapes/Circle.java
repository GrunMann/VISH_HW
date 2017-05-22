package shapes;
import static java.lang.Math.PI; 
import shapes.exceptions.UnsupportedArgumentExceptin; 

public class Circle extends Shape {

    private final float radius;
    
    
    public Circle(float radius) throws UnsupportedArgumentExceptin { // конструктор класса Circle 
        if (!isSupportedRadius (radius)) {  // проверка корректности заданного радиуса
            throw new UnsupportedArgumentExceptin ("Invalid radius for circle"); 
        }
        this.radius = radius;
    } 
    
    private boolean isSupportedRadius (float radius) {
        return radius > 0; 
    }    

    public float getRadius () {
        return radius; 
    }
    
    public float getLenght () {
        return (2f*  3.14f * radius); 
    }
    public float getPerimeter () {
        return getLenght(); 
    }
    public float getArea (){ 
        return(float) (PI * radius * radius); 
    }
    
}