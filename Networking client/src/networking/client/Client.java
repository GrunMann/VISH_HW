package networking.client;

import java.io.Closeable;
import java.io.IOException;

public interface Client extends Closeable{
    void send(String message) throws IOException;
    
}
