package helpers;
import shapes.Point;
public class Random extends java.util.Random{

    /**
    *Method bring random float value from 0 to 100
    *@return Random float value from 0 to 100
    **/
    @Override
    public float nextFloat() {
        return super.nextFloat() * 100f; 
    }
    
    public Point nextPoint(){
        return new Point(nextFloat(), nextFloat());
    }
    
}
