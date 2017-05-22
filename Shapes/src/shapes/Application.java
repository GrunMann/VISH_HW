package shapes;
import geometry.Circle;
import geometry.Filter;
import geometry.Point;
import geometry.Random;
import geometry.Triangle;
import geometry.Shape;
import geometry.Search;


public class Application {

       public static void main(String[] args) {
           Random   random  = new Random();
           Shape[]  shapes  = random.shapes(10);
           Search   search  = new Search(shapes);
           Filter   filter  = new FirstTriangleFilter();
           Shape    shape   = new Search(shapes).run(filter);
    }

}