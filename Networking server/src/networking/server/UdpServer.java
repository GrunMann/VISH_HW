package networking.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer extends DatagramSocket implements Server{
    
    private final DatagramPacket packet;
    
    public UdpServer (int port) throws SocketException{
        super(port);
        byte [] buffer = new byte[100];
        packet = new DatagramPacket(buffer, buffer.length);
    }
    
    @Override
    public String listen() throws IOException {
        receive(packet);
        return new String(packet.getData());
    }
    
}
