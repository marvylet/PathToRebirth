package Characters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Character {
    private String name;
    private ArrayList<Integer> rooms;
    private int relation;
    private ArrayList<String> dialogue;

    public Character(String name, int relation) {
        this.name = name;
        this.relation = relation;
        rooms = new ArrayList<>();
        dialogue = new ArrayList<>();
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

    public abstract String getDialogue();

    public abstract int changeRelation();
}
