package test.server;

public class TestServer {

       public static void main(String[] args) {
           try (ServerDaemon daemon = new ServerDaemon()){
               daemon.start();
               System.out.println("Strarted! Press Enter to colse thread");
               System.in.read();
                      
           } catch (Exception e) {
               System.err.println(e.getMessage());
           }
    }

}