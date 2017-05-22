package shapes.search;

import shapes.Shape;

final public class Search {

    private final Shape[] shapes;

    public Search(Shape[] shapes) {
        this.shapes = shapes;
    }
    public void run (NewInterface filter) {
        for (Shape shape : shapes) {
            filter.filter (shape); 
            if (filter.exit())break; 
        }
    }
}
