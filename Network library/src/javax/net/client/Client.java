package javax.net.client;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

public interface Client<E extends Serializable> extends Closeable{
    
    E receive() throws IOException;
    
    void  send (E message) throws IOException;
    
    static <E extends Serializable> Client<E> create (Socket socket) throws IOException{
        return new TcpClient<>(socket);
    }
    
    static <E extends Serializable> Client<E> create(InetAddress address, int port) throws IOException{
        return new TcpClient<>(address,port);
    }
}
