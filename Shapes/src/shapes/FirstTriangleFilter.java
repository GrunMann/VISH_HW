package shapes;
import geometry.Filter;
import geometry.Shape;
import geometry.Triangle;

public class FirstTriangleFilter implements Filter{
    public boolean doFilter(Shape shape){
        return shape instanceof Triangle;
    }
}
