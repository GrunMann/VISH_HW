package testclient;

import java.net.InetAddress;
import javax.net.client.Client;

public class Application {

       public static void main(String[] args) {
        
           try (Client<String> client = Client.create(InetAddress.getLocalHost(),1001)){
               client.send("message");
           } catch (Exception e) {
               e.printStackTrace(System.err);
           }
    }

}