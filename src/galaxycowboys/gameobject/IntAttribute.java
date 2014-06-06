package galaxycowboys.gameobject;

public class IntAttribute extends GameObject {

    public final String key;
    
    public final Integer value;
    
    public IntAttribute(Player player, GameObject parent, String key, Integer value) {
        super(player, parent);
        this.key=key;
        this.value=value;
    }
    
    public String getKey() {
        return key;
    }
    
    public Integer getValue() {
        return value;
    }
    
}
