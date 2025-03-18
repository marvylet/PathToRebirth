package Items;

import java.util.ArrayList;

public abstract class Item {
    private String name;
    private ArrayList<Integer> rooms;

    public Item(String name) {
        this.name = name;
        rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract String getDescription();

    public abstract String getEffect();

    public abstract boolean effect();

    public abstract boolean grabbable();

    public abstract boolean moveable();
}
