package galaxycowboys;

import galaxycowboys.gameobject.Galaxy;
import galaxycowboys.gameobject.Star;
import galaxycowboys.gameobject.Turn;
import galaxycowboys.net.Server;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        Turn turn = new Turn(null);
        Galaxy galaxy = new Galaxy(turn);
        Star star1 = new Star(galaxy);
        Star star2 = new Star(galaxy);
        
        TurnManager turnManager = new TurnManager(turn);
        
        
        
        Server server = new Server(8080, turnManager);
        server.start();
        System.in.read();
        server.stop();
    }
    
}
