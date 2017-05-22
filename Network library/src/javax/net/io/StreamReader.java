package javax.net.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class StreamReader<E extends Serializable> extends ObjectInputStream implements Reader<E>{

    public StreamReader(InputStream stream) throws IOException {
        super(stream);
    }

    @Override
    public E readMessage() throws IOException {
        try{
            return (E) readObject();
        }catch (ClassNotFoundException e){
            throw new IOException(e);
        }
        
    }
    
    
}
