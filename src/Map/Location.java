package Map;

import Characters.Character;
import Items.Item;

import java.util.ArrayList;

public class Location {
    private int ID;
    private String name;
    private ArrayList<Integer> connectedRooms;
    private ArrayList<Character> characters;
    private boolean keyLocked;
    private boolean moveLocked;

    public Location(int ID, String name, ArrayList<Integer> connectedRooms, boolean keyLocked, boolean moveLocked, ArrayList<Character> characters) {
        this.ID = ID;
        this.name = name;
        this.connectedRooms = connectedRooms;
        this.characters = characters;
        this.keyLocked = keyLocked;
        this.moveLocked = moveLocked;
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


    public String viewChararacters(){
        String s = "";
        for(int i = 0; i < characters.size(); i++){
            s += characters.get(i).getName() + "\n";
        }
        return s;
    }

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
