package Map;

import Characters.Character;
import Items.Item;

import java.util.ArrayList;

public class Location {
    private int ID;
    private String name;
    private ArrayList<Integer> connectedRooms;
    private ArrayList<Character> characters;

    public Location(int ID, String name, ArrayList<Integer> connectedRooms) {
        this.ID = ID;
        this.name = name;
        this.connectedRooms = connectedRooms;
        this.characters = new ArrayList<>();
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

    public boolean loadChararacters(Character character){
        for(int i = 0; i < character.getRooms().size(); i++){
            if(character.getRooms().get(i) == ID){
                characters.add(character);
                return true;
            }
        }
        return false;
    }

    //public ArrayList<Item> loadItems(){}



    @Override
    public String toString() {
        return "Location{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", connectedRooms=" + connectedRooms +
                '}';
    }
}
