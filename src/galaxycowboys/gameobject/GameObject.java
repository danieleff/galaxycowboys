package galaxycowboys.gameobject;

import java.util.List;

public abstract class GameObject {
    
    protected GameObject parent;

    protected List<GameObject> childs;
    
    protected Player owner;
    
    protected GameObject(Player owner, GameObject parent) {
        this.owner=owner;
        if (parent!=null) attachToParent(parent);
    }
    
    public String getStringAttribute(String key, String def) {
        for (GameObject i : childs) {
            if (i instanceof StringAttribute && ((StringAttribute) i).getKey().equals(key))  {
                return ((StringAttribute) i).getValue();
            }
        }
        return def;
    }
    
    public Integer getIntAttribute(String key, Integer def) {
        for (GameObject i : childs) {
            if (i instanceof IntAttribute && ((IntAttribute) i).getKey().equals(key))  {
                return ((IntAttribute) i).getValue();
            }
        }
        return def;
    }

    public <T extends GameObject> T createCopy() {
        throw new Error("Not implemented");
    }
    
    public void attachToParent(GameObject parent) {
        if (this.parent!=null) detach(this.parent);
        this.parent=parent;
        parent.attach(this);
    }
    
    protected void detachFromParent() {
        parent=null;
        parent.detach(this);
    }

    private void attach(GameObject gameObject) {
        childs.add(gameObject);
    }
    
    private boolean detach(GameObject gameObject) {
        return childs.remove(gameObject);
    }

}
