package networking.client;

import java.io.IOException;
import java.net.InetAddress;

public class Application {

    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            try (Client client = new TcpClient(InetAddress.getByName("192.168.16.130"),1001)) {
                client.send("client connected to server " + i);

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
