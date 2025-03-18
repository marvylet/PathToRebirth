package Map;

import Items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private int capacity;
    private HashMap<String, Item> items;
    private ArrayList<String> itemNames;

    public Inventory() {
        capacity = 5;
        items = new HashMap<>();
        itemNames = new ArrayList<>();
    }

    public boolean addItem(String name, Item item){
        if(items.size() < capacity){
            items.put(name, item);
            itemNames.add(name);
            return true;
        }
        return false;
    }

    public String viewInventory(){
        String inventory = "";
        for(int i = 0; i < itemNames.size(); i++){
            inventory += "  " + itemNames.get(i) + "\n";
        }
        return inventory;
    }

    public String viewItemDesc(String name){
        if(items.containsKey(name)){
            return items.get(name).getDescription();
        }
        return "No such item";
    }

}
