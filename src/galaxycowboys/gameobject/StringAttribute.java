package galaxycowboys.gameobject;

public class StringAttribute extends GameObject {

    public final String key;
    
    public final String value;
    
    public StringAttribute(Player player, GameObject parent, String key, String value) {
        super(player, parent);
        this.key=key;
        this.value=value;
    }
    
    public String getKey() {
        return key;
    }
    
    public String getValue() {
        return value;
    }
    
}
