package networking.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class UdpClient extends DatagramSocket implements Client{

    public UdpClient (SocketAddress address)throws SocketException{
        connect(address);
        
    }
    
    public UdpClient(InetAddress address, int port) throws SocketException{
        this(new InetSocketAddress(address, port));
    }
    
    @Override
    public void send(String message) throws IOException {
        byte[] bytes = message.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        send(packet);
    }
    
}
