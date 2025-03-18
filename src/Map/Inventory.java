package Map;

import Items.Item;
import Items.Note;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private int capacity;
    private HashMap<String, Item> items;
    private ArrayList<String> itemNames;
    private ArrayList<Item> notes;

    public Inventory() {
        capacity = 5;
        items = new HashMap<>();
        itemNames = new ArrayList<>();
        notes = new ArrayList<>();
    }

    public boolean addItem(String name, Item item){
        if(items.size() < capacity){
            items.put(name, item);
            itemNames.add(name);
            return true;
        }
        return false;
    }

    public boolean containsItem(String name){
        if(items.containsKey(name)){
            return true;
        }
        return false;
    }

    public String effect(String name){
        if(items.containsKey(name)){
            if(items.get(name).getDescription().equals("")){
                return "Item does not have an effect.";
            }else{
                return items.get(name).getDescription();
            }
        }
        return "Item not found";
    }

    public boolean addNote(Item note){
        if(note != null){
            notes.add(note);
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
