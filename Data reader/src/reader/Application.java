package reader;

import io.PointReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import shapes.Point;

public class Application {
    
    static final File file;
    static final Collection<Point> points;
    static{
        file=new File("points.txt");
        points = new HashSet<>();
    }
    
    public static void main(String[] args) {
        try(PointReader reader = new PointReader(file)){
            Point point;
            while  ((point=reader.read())!= null){
                points.add(point);
            }
            
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

}