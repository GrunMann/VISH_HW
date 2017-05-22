package io;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import shapes.Point;
import java.io.File;
import java.io.Closeable;


public class PointWriter implements Closeable {
    
    private PrintWriter writer;
    private boolean empty=true;
    
    public PointWriter(OutputStream stream){
        writer = new PrintWriter(stream);
    }
    
    public PointWriter(File file) throws FileNotFoundException {
        this(new FileOutputStream(file));
    }
    
    public void println (Point point){
        if(!empty) writer.println();
        else empty = false;
        writer.print(point);//calls toString by default
    }

    @Override
    public void close() throws IOException {
        writer.close();
        writer=null;
    }
    
}
