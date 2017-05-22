package javax.net.client;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import javax.net.io.Reader;
import javax.net.io.Writer;

public class TcpClient <E extends Serializable> implements Client<E>{

    private final Socket socket;
    private final Writer<E> writer;
    private final Reader<E> reader;

    public TcpClient(Socket socket) throws IOException{
        this.socket = socket;
        writer = Writer.getInstance(socket.getOutputStream());
        reader = Reader.getInstance(socket.getInputStream());
    }

    public TcpClient(InetAddress address, int port) throws IOException{
        this(new Socket(address, port));
    }
    
    
            
    @Override
    public void send(E message) throws IOException {
        writer.writeMessage(message);
    }

    @Override
    public E receive() throws IOException {
        return reader.readMessage();
    }

    @Override
    public void close() throws IOException {
        socket.close();
        reader.close();
        writer.close();
    }

}
