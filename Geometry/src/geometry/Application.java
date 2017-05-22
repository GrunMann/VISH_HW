package geometry;

import shapes.Shape;
import shapes.Random;
import shapes.search.Search;

public class Application {

    public static void main(String[] args) {
        final Random random = new Random();
        Shape[] shapes = random.shapes(10);
        Search search = new Search (shapes); 
           
        MaxPerimeterFilter filter = new MaxPerimeterFilter (); 
        search.run(filter);
    }

}
