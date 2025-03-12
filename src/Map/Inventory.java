package Map;

import Items.Item;

import java.util.HashMap;

public class Inventory {
    private int capacity;
    private HashMap<String, Item> items;

    public Inventory() {
        capacity = 3;
        items = new HashMap<>();
    }

    public boolean addItem(String name, Item item){
        if(items.size() < capacity){
            items.put(name, item);
            return true;
        }
        return false;
    }

}
