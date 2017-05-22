package geometry;
import static java.lang.Math.abs;

public class Random extends java.util.Random{
    
    @Override
    public float nextFloat(){
        float a=nextInt(10);
        float b=nextInt(100);
        return a+b/100f;
    }
    public Point nextPoint (){
        return new Point(nextFloat(), nextFloat());
    }
    
    public Triangle nextTriangle (){
        try{
            return new Triangle(nextPoint(), nextPoint(), nextPoint());
        }catch(IllegalArgumentException e){
            return nextTriangle();
        }
    }
    
    public Circle nextCircle (){
        return new Circle(nextFloat());
    }
    
    public Shape nextShape(){
        switch(abs(nextInt()%2)){
            case 0: 
                return nextTriangle();
            case 1:
                return nextCircle();
            default:
                throw new UnsupportedOperationException("Impossible");
        }
    }
    
    public Shape[] shapes(int n){
        Shape[] shapes= new Shape[n];
        while (n-->0)shapes[n]=nextShape();
        return shapes;
    }
}
