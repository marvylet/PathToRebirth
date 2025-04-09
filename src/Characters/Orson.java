package Characters;

import Map.Inventory;

import java.util.Scanner;

public class Orson extends Character {
    public Orson(String name, Inventory inv, Scanner sc) {
        super(name, inv, sc);
        this.relation = -1;
        loadDialogue("Resources/OrsonDialogue");
    }

    /**
     * A method which returns dialogue from a switch depending on the relationship to the character.
     *
     * @return - returns String value of specific dialogue
     */
    @Override
    public String getDialogue() {
        if (relation <= -2) {
            return negativeDialogue();
        } else if (inv.getNotes().size() >= 3) {
            return insultOrComplimentDialogue();
        }
        return neutralDialogue();
    }

    public String negativeDialogue() {
        switch (index3) {
            case 0:
                index3++;
                return dialogue.get(7);
            case 1:
                index3++;
                return dialogue.get(8);
            case 2:
                return dialogue.get(9);
        }
        return "";
    }

    /**
     * Lets the player choose if they wish to compliment the character, insult them or give them a gift.
     *
     * @return - returns String value of specific dialogue
     */
    public String insultOrComplimentDialogue() {
        System.out.println(dialogue.get(2));
        System.out.print("> ");
        String option = sc.next();
        switch (option) {
            case "insult":
                return dialogue.get(3);
            case "compliment":
                return dialogue.get(4);
            case "gift":
                return dialogue.get(5);
            default:
                return dialogue.get(6);
        }
    }

    /**
     * Neutral dialogue that activates when the player first talks to the character or didn't progress the game enough yet.
     *
     * @return - returns String value of specific dialogue
     */
    public String neutralDialogue() {
        index1 = 0;
        switch (index1) {
            case 0:
                index1++;
                return dialogue.get(0);
            case 1:
                return dialogue.get(1);
        }
        return "";
    }


}
