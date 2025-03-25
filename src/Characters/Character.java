package Characters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Character {
    protected String name;
    protected ArrayList<Integer> rooms;
    protected int relation;
    protected ArrayList<String> dialogue;
    protected int index;
    protected int charID;

    public Character(String name) {
        this.name = name;
        rooms = new ArrayList<>();
        dialogue = new ArrayList<>();
        index = 0;
    }

    public boolean loadDialogue(String file){
        try {
            BufferedReader buff = new BufferedReader(new FileReader(file));

            String line;
            while ((line = buff.readLine()) != null) {
                dialogue.add(line);
            }

            return true;
        }catch (IOException e){
            return false;
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public abstract String getDialogue();

    public  int changeRelationPos(){
        relation += 1;
        return relation;
    }
    public  int changeRelationNeg(){
        relation -= 1;
        return relation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Integer> rooms) {
        this.rooms = rooms;
    }

    public int getCharID() {
        return charID;
    }

    public void setCharID(int charID) {
        this.charID = charID;
    }

    //Looked up about factory in https://refactoring.guru/design-patterns/factory-method
    //Rewrote it in a switch instead of if else
    public static Character factory(String charName){
        return switch(charName){
            case "Aiysha" -> new Aiysha(charName);
            case "Ezra" -> new Ezra(charName);
            case "Hajoon" -> new Hajoon(charName);
            case "Orson" -> new Orson(charName);
            case "Taylor" -> new Taylor(charName);
            default -> null;
        };
    }
}
