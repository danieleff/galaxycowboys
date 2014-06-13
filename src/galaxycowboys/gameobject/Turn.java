package galaxycowboys.gameobject;

import java.io.InputStream;
import java.io.OutputStream;


public class Turn extends GameObject {

    public int turnCount;
    
    public byte[] hash;
    
    public Turn(byte[] previousTurnHash) {
        super(null, null);
        hash = previousTurnHash;
    }

    public Galaxy getGalaxy() {
        for (GameObject child : childs) {
            if (child instanceof Galaxy) {
                 return (galaxycowboys.gameobject.Galaxy) child;
            }
        }
        throw new Error("Turn should contain a galaxy!");
    }
    
    public void serialize(OutputStream out) {
        
    }
    
    public static Turn deserialize(InputStream in) {
        return null;
    }
    
}
