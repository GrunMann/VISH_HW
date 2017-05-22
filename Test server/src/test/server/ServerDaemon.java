package test.server;
import java.io.IOException;
import javax.net.TcpServer;
import javax.net.client.Client;
import javax.threading.Deamon;
public class ServerDaemon extends Deamon{

    private final TcpServer<String> server;
    public  ServerDaemon()throws IOException{
        this.server = TcpServer.create(1001);
    }
    
    @Override
    protected void doInBackground() throws Exception {
        Client<String> client = server.listen();
        new ClientDaemon(client).start();
    }

    @Override
    public void close() throws Exception {
        super.close();
        server.close();
    }
    
}
