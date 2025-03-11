package Characters;

import java.util.ArrayList;

public class Character {
    private String name;
    private ArrayList<Integer> rooms;
    private int relation;

    public Character(String name, int relation) {
        this.name = name;
        this.relation = relation;
        rooms = new ArrayList<>();
    }

    public String getDialogue(){}

    public int changeRelation(){}
}
