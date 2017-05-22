package geometry;

import shapes.Circle;
import shapes.Shape;
import shapes.search.NewInterface;

public class FirstCircleFilter implements NewInterface {
private Circle needle; 
public void filter (Shape shape) { 
    if (shape instanceof Circle) {
        needle = (Circle) shape; 
    }
}
    public boolean exit() {
        return needle != null; 
    }
    public Circle getNeedle () {
        return needle; 
    }
}
