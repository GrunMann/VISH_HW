package generator;

import helpers.Random;
import io.PointWriter;
import java.io.File;
import java.io.IOException;

public class Application {
    
    final static File file;
    final static Random random;
    
    static{
        file = new File("points.txt");
        random=new Random();
    }
    
    public static void main(String[] args) {
        try{
            if(!file.exists()) file.createNewFile();
            try(PointWriter writer = new PointWriter(file)){
                for (int i = 0; i < 20; i++) {
                    writer.println(random.nextPoint());
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}