package javax.net.io;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class StreamWriter<E extends Serializable> extends ObjectOutputStream implements Writer<E>{

    public StreamWriter(OutputStream stream) throws IOException {
        super(stream);
    }

    @Override
    public void writeMessage(E message) throws IOException {
        writeObject(message);
        flush();
    }
    
}
