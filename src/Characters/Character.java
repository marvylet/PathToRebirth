package Characters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * An abstract class that works for creating characters
 */
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

    /**
     * A method for importing dialogue from a file to an ArrayList
     * @param file - the file which the method imports the dialogue from
     * @return - returns true if nothing went wrong, false if an exception happened
     */
    public boolean loadDialogue(String file){
        try {
            BufferedReader buff = new BufferedReader(new FileReader(file));

            String line;
            while ((line = buff.readLine()) != null) {
                dialogue.add(line);
            }

            buff.close();
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

    /**
     * A factory method which is used in MansionMap when adding characters from a file in a room
     * Looked up about factory in https://refactoring.guru/design-patterns/factory-method
     * @param charName - the character's name, based on it creates a new character
     * @return - returns a switch which creates a new character depending on charName
     */
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
