package Items;

import java.util.ArrayList;

public abstract class Item {
    private String name;
    private ArrayList<Integer> rooms;
    private boolean grabbable;
    private boolean moveable;

    public Item(String name, boolean grabbable, boolean moveable) {
        this.name = name;
        this.grabbable = grabbable;
        this.moveable = moveable;
        rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGrabbable() {
        return grabbable;
    }

    public void setGrabbable(boolean grabbable) {
        this.grabbable = grabbable;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public void setMoveable(boolean moveable) {
        this.moveable = moveable;
    }

    public abstract String getDescription();

    public abstract String getEffect();
}
