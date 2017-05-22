package io;
import io.exceptions.ParseException;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import shapes.Point;

public class PointReader implements Closeable{
    
    private BufferedReader reader; 
    
    public PointReader (InputStream stream){
        reader = new BufferedReader(new InputStreamReader(stream));
    }
    
    public PointReader (File file) throws FileNotFoundException{
        this (new FileInputStream(file));
    }
    
    public Point read() throws IOException{
        String line = reader.readLine();
        /*if (line != null) {
            return Point.valueOf(line);
        }
        return null;*/
        try{
            return line != null ? Point.valueOf(line) : null;
        }catch (ParseException ignore){}
        return read();
    }

    @Override
    public void close() throws IOException{
        reader.close();
        reader=null;
    }
    
}
