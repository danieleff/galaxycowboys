package galaxycowboys;

import galaxycowboys.net.Server;

import java.io.IOException;


public class Main {

        public static void main(String[] args) throws IOException {
        Server server = new Server(8080);
        server.start();
        System.in.read();
        server.stop();
    }
    
}
