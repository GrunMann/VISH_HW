package geometry;

public class Search {
    
    private final Shape[] shapes;

    public Search(Shape[] shapes) {
        this.shapes = shapes;
    }
    
    public Shape run(Filter filter){
        for (Shape shape : shapes){
            if (filter.doFilter(shape)){
                return shape;
            }
        }
        return null;
    }
    
}
