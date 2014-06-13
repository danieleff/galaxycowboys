package galaxycowboys;

import galaxycowboys.gameobject.Command;
import galaxycowboys.gameobject.Galaxy;
import galaxycowboys.gameobject.Turn;

import java.util.List;

public class TurnManager {

    public Turn getPrevious() {
        return null;
    }
    
    public Turn doTurn() {
        Turn copy = getPrevious().createCopy();
        Galaxy galaxy=copy.getGalaxy();
        
        for (Command pendingCommand : getPendingCommands(getPrevious().hash)) {
            if (pendingCommand.execute(galaxy)) {
                Command savedCommand = pendingCommand.createCopy();
                savedCommand.attachToParent(copy);
            }
        }

        return copy;
    }
    
    public List<Turn> getRoots() {
        return null;
    }
    
    public List<Command> getPendingCommands(byte[] hash) {
        return null;
    }
    
    public void addPendingCommand(Command command) {
        
    }
    
}
