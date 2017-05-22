package geometry;

import shapes.Shape;
import shapes.search.NewInterface;

public class MaxPerimeterFilter implements NewInterface {

    private Shape max;

    public Shape getNeedle() {
        return max;
    }

    public boolean exit () {
        return false; 
    }
    
    public void filter (Shape shape) { 
        if (max == null || shape.getPerimeter()> max.getPerimeter()){
            max = shape; 
        }
    }
}
