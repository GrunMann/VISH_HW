package networking.server;

import java.io.IOException;

public class Application {

       public static void main(String[] args) {
           try (Server server = new TcpServer(1001)){
               for (int i = 0; i < 10; i++) {
                   String message = server.listen();
                   System.out.println(message);
               }
           } catch (IOException e) {
               System.err.println(e.getMessage());
           }
    }

}