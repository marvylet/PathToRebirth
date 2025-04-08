package Map;

import Characters.Character;
import Items.Item;

import java.util.ArrayList;

/**
 * A class used for creating rooms and locations in the game
 */
public class Location {
    private int ID;
    private String name;
    private ArrayList<Integer> connectedRooms;
    private ArrayList<Character> characters;
    private ArrayList<Item> items;
    private boolean keyLocked;
    private boolean moveLocked;
    private Inventory inv;

    public Location(int ID, String name, ArrayList<Integer> connectedRooms, boolean keyLocked, boolean moveLocked, ArrayList<Character> characters, ArrayList<Item> items, Inventory inv) {
        this.ID = ID;
        this.name = name;
        this.connectedRooms = connectedRooms;
        this.characters = characters;
        this.items = items;
        this.keyLocked = keyLocked;
        this.moveLocked = moveLocked;
        this.inv = inv;
    }

    public boolean isKeyLocked() {
        return keyLocked;
    }

    public void setKeyLocked(boolean keyLocked) {
        this.keyLocked = keyLocked;
    }

    public boolean isMoveLocked() {
        return moveLocked;
    }

    public void setMoveLocked(boolean moveLocked) {
        this.moveLocked = moveLocked;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getConnectedRooms() {
        return connectedRooms;
    }

    public void setConnectedRooms(ArrayList<Integer> connectedRooms) {
        this.connectedRooms = connectedRooms;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Used for listing all the characters in the room
     * @return - returns list of the characters' names that are currently in the room
     */
    public String viewCharacters(){
        String s = "";
        for(int i = 0; i < characters.size(); i++){
            s += characters.get(i).getName() + "\n";
        }
        return s;
    }

    /**
     * Used for listing all the items in the room
     * @return - returns list of all the items' names that are currently in the room
     */
    public String viewItems(){
        String s = "";
        for(int i = 0; i < items.size(); i++){
            s += items.get(i).getName() + "\n";
        }
        return s;
    }

    /**
     * Used for finding out if the item is in the room, afterwards removing it
     * Used in grab command
     * @param name - name of the item we're trying to find out if it's in the room
     * @return - returns the item that's in there or null if it isn't
     */
    public Item findAndRemoveItem(String name){
        Item item = null;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getName().equals(name)){
                if(inv.freeInv()){
                    item = items.get(i);
                    items.remove(items.get(i));
                }
                return item;
            }
        }
        return null;
    }


    /**
     * A method used for finding out if the item is in the room.
     * @param name - name of the item the player wants find
     * @return - returns either the item or null if it isn't there
     */
    public Item findItem(String name){
        Item item = null;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getName().equals(name)){
                if(inv.freeInv()){
                    item = items.get(i);
                }
                return item;
            }
        }
        return null;
    }

    /**
     * Used for unlocking a door in Interact command, makes the boolean false, making the room unlocked
     * @return - returns information about the room being unlocked
     */
    public String unlockDoor(){
        setKeyLocked(false);
        inv.removeItem("Key");
        return "Door unlocked.";
    }

    /**
     * Used for moving an item in Move command.
     * Checks if specific item is moveable, if it is then unlocks the room.
     * @param item - item that it checks if its moveable
     * @return - returns confirmation about item being moved or information about it not being moveable
     */
    public String moveItem(Item item){
        try {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(item.getName())) {
                    if (item.moveable()) {
                        setMoveLocked(false);
                        return "Item successfully moved!";
                    }
                }
            }
            return "Couldn't move item.";
        }catch (Exception e){
            return "Something went wrong.";
        }
    }

    private String moveItemNeighbouring(Item item){
        try {
            boolean confirm = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(item.getName())) {
                    if (item.moveable()) {
                        setMoveLocked(false);
                        confirm = true;
                    }
                }
            }
            for(int i = 0; i < connectedRooms.size(); i++){}
            return "Couldn't move item.";
        }catch (Exception e){
            return "Something went wrong.";
        }
    }

    /**
     * A method for dropping items from inventory to the current room the player is in.
     * @param itemName - the name of the item the player wishes to remove from their inventory
     * @return - either returns confirmation about removal of item, or that something went wrong.
     */
    public String removeItem(String itemName){
        if(inv.containsItem(itemName)){
            items.add(inv.getItems().get(itemName));
            inv.removeItem(itemName);
            return "Item successfully dropped!";
        }
        return "Couldn't drop item.";
    }

    /**
     * Used for talking to characters in Talk command.
     * checks whole list if the character is in the room, if yes gets their dialogue
     * @param charName - character its checking for it's dialogue
     * @return - returns character's dialogue or information about the character not being there
     */
    public String talkToChar(String charName){
        for(int i = 0; i < characters.size(); i++){
            if(characters.get(i).getName().equals(charName)){
                return characters.get(i).getDialogue();
            }
        }
        return "No such character";
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Location{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", connectedRooms=" + connectedRooms +
                '}';
    }
}
