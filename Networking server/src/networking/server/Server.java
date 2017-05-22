package networking.server;

import java.io.Closeable;
import java.io.IOException;

public interface Server extends Closeable{
    String listen() throws IOException;
}
