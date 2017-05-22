package javax.net.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public interface Writer<E extends Serializable> extends Closeable{
    void writeMessage (E message) throws IOException;
    
    static <E extends Serializable> Writer<E> getInstance (OutputStream stream) throws IOException{
        return new StreamWriter<>(stream);
    }
}
