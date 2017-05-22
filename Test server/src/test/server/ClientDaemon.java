package test.server;

import javax.net.client.Client;
import javax.threading.Deamon;

public class ClientDaemon extends Deamon{

    private final Client<String> client;

    public ClientDaemon(Client<String> client) {
        this.client = client;
    }
    
    @Override
    protected void doInBackground() throws Exception {
        String message = client.receive();
        System.out.println(message);
        close();
    }

    @Override
    public void close() throws Exception {
        super.close();
        client.close();
    }
    
    
}
