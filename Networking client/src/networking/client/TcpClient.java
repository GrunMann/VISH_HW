package networking.client;

import java.beans.Introspector;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient extends Socket implements Client{

    private final BufferedWriter writer;
    
    public TcpClient(InetAddress address, int port) throws IOException{
        super(address, port);
        OutputStreamWriter output = new OutputStreamWriter(getOutputStream());
        writer= new BufferedWriter(output);
        
    }

    
    
    @Override
    public void send(String message) throws IOException {
        writer.write(message);
        writer.flush();
    }
    
}
