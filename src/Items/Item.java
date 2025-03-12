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


    public abstract String getDescription();

    public abstract String getEffect();
}
