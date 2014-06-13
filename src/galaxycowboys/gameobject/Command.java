package galaxycowboys.gameobject;

public class Command extends GameObject {

    public Command(Player owner, Turn parent) {
        super(owner, parent);
    }
    
    public byte[] getHash() {
        return null;
    }

    public boolean execute(Galaxy galaxy) {
        return false;
    }
    
}
