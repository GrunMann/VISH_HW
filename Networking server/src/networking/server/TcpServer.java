package networking.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer extends ServerSocket implements Server{

    public TcpServer( int port) throws IOException {
        super(port);
    }

    @Override
    public String listen() throws IOException {
        try (Socket client = accept()){
            InputStream stream=client.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader in = new BufferedReader(reader);
            return in.readLine();
        } 

        
    }
    
}
