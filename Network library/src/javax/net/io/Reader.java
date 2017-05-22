package javax.net.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public interface Reader<E extends Serializable> extends Closeable{
    
    E readMessage() throws IOException;
    static  <E extends Serializable> Reader<E> getInstance (InputStream stream)throws IOException{
        return new StreamReader<>(stream);
        
    }
    
}
