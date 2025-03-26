package Map;

import Items.Item;
import Items.Lantern;
import Items.Note;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private int capacity;
    private HashMap<String, Item> items;
    private ArrayList<String> itemNames;
    private ArrayList<Item> notes;
    private ArrayList<String> noteNames;

    public Inventory() {
        capacity = 5;
        items = new HashMap<>();
        itemNames = new ArrayList<>();
        notes = new ArrayList<>();
        noteNames = new ArrayList<>();
        items.put("Lantern", new Lantern("Lantern"));
    }

    public ArrayList<Item> getNotes() {
        return notes;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public String addItem(Item item){
        try {
            if (items.size() < capacity) {
                if ((item instanceof Note)) {
                    notes.add(item);
                    noteNames.add(item.getName());
                    return "Note successfully added.";

                } else if (item.grabbable()) {
                    items.put(item.getName(), item);
                    itemNames.add(item.getName());
                    return "Item successfully added";
                }
            }
        } catch (Exception e) {
            return "Invalid item.";
        }
        return "Item is not grabbable";
    }

    public boolean freeInv(){
        if(items.size() < capacity){
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

    public boolean removeItem(String name){
        if(items.containsKey(name)){
            items.remove(name);
            return true;
        }
        return false;
    }

    public String effect(String name){
        if(items.containsKey(name)){
            if(items.get(name).getDescription().isEmpty()){
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
            noteNames.add(note.getName());
            return true;
        }
        return false;
    }

    public String viewDiary(){
        String diary = "";
        for(int i = 0; i < noteNames.size(); i++){
            diary += "  " + noteNames.get(i) + "\n";
        }
        return diary;
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
