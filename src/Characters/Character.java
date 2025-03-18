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

    public Character(String name, int relation) {
        this.name = name;
        this.relation = relation;
        rooms = new ArrayList<>();
        dialogue = new ArrayList<>();
        index = 0;
    }

    public boolean loadDialogue(String file){
        try {
            BufferedReader buff = new BufferedReader(new FileReader(file));

            String line = buff.readLine();
            while (line != null) {
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

    public abstract void addRooms();

    public ArrayList<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Integer> rooms) {
        this.rooms = rooms;
    }
}
