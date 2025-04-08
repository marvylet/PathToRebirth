package Characters;

import Map.Inventory;

import java.util.Scanner;

public class Orson extends Character {
    public Orson(String name, Inventory inv, Scanner sc) {
        super(name, inv, sc);
        this.relation = -2;
        loadDialogue("Resources/OrsonDialogue");
    }
    /**
     * A method which returns dialogue from a switch depending on how many times the player talks to them.
     * @return - returns String value of specific dialogue
     */
    @Override
    public String getDialogue() {
        switch (index) {
            case 0:
                index++;
                return dialogue.get(0);
            case 1:
                index++;
                return dialogue.get(1);
            case 2:
                index++;
                return dialogue.get(2);
            case 3:
                index = 0;
                return dialogue.get(3);
        }

        return "";
    }




}
