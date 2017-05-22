package javax.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import javax.net.client.Client;

public interface TcpServer<E extends Serializable> extends Closeable{
    
    Client<E> listen () throws IOException;
    static <E extends Serializable> TcpServer<E> create (int port) throws IOException{
        return new TcpServerImpl<>(port);
    }
    
}

class TcpServerImpl <E extends Serializable> extends ServerSocket implements TcpServer<E>{

    public TcpServerImpl(int port) throws IOException {
        super(port);
    }

    @Override
    public Client<E> listen() throws IOException {
        return Client.create(accept());
    }

    
    
}
