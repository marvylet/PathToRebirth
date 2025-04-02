package Map;

import Items.Item;
import Items.Lantern;
import Items.Note;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class which is used for saving items into player's inventory
 */
public class Inventory {
    private int capacity;
    private HashMap<String, Item> items;
    private ArrayList<Item> notes;
    private ArrayList<String> noteNames;

    public Inventory() {
        capacity = 5;
        items = new HashMap<>();
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

    /**
     * Method used for adding a specific item in inventory.
     * Checks if it's a Note, if yes adds to diary
     * Afterwards checks if the item is grabbable, if yes adds to inventory
     * @param item - item which is being added to inventory
     * @return - returns either confirmation about item being added, or that something went wrong
     */
    public String addItem(Item item){
        try {
            if (freeInv()) {
                if ((item instanceof Note)) {
                    notes.add(item);
                    noteNames.add(item.getName());
                    return "Note successfully added.";

                } else if (item.grabbable()) {
                    items.put(item.getName(), item);
                    return "Item successfully added";
                }
            }
        } catch (Exception e) {
            return "Invalid item.";
        }
        return "Item is not grabbable";
    }

    /**
     * Checks if there's any space left in the inventory depending on it's capacity
     * @return - returns true if there's space, false if not
     */
    public boolean freeInv(){
        if(items.size() < capacity){
            return true;
        }
        return false;
    }

    /**
     * Checks if specific item is in the inventory
     * @param name - name of the item that its checking if it's there
     * @return - returns true if the item is in inventory, false if not
     */
    public boolean containsItem(String name){
        if(items.containsKey(name)){
            return true;
        }
        return false;
    }

    /**
     * Removes specific item
     * @param name - name of the item its removing
     * @return - returns true if it's been successfully removed, false if otherwise
     */
    public boolean removeItem(String name){
        if(items.containsKey(name)){

            items.remove(name);

            return true;
        }
        return false;
    }

    /**
     * Checks if it has an effect or not thanks to the boolean.
     * @param name - name of the item which effect we want to get
     * @return - either returns the effect, or that it doesn't have one, or that item wasn't found
     */
    public String effect(String name){
        if(items.containsKey(name)){
            if(!items.get(name).effect()){
                return "Item does not have an effect.";
            }else{
                return items.get(name).getDescription();
            }
        }
        return "Item not found";
    }

    /**
     * Used for viewing all the notes currently saved in ArrayList
     * @return - returns all the notes currently saved
     */
    public String viewDiary(){
        String diary = "";
        for(int i = 0; i < noteNames.size(); i++){
            diary += "  " + noteNames.get(i) + "\n";
        }
        return diary;
    }

    /**
     * Used for viewing all the items saved in ArrayList
     * @return - returns list of items in the inventory
     */
    public String viewInventory(){
        String inventory = "";
        for(String item : items.keySet()){
            inventory += "  " + items.get(item).getName() + "\n";
        }
        return inventory;
    }

    /**
     * Used for viewing description of an item
     * @param name - name of the item which description we're getting
     * @return - returns description or that item wasn't found
     */
    public String viewItemDesc(String name){
        if(items.containsKey(name)){
            return items.get(name).getDescription();
        }
        return "No such item";
    }

}
