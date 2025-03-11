package Items;

import java.util.ArrayList;

public class Item {
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


    public String getDescription() {}

    public String getEffect(){}
}
