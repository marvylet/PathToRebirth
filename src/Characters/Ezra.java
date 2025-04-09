package Characters;

import Map.Inventory;

import java.util.Scanner;

public class Ezra extends Character {
    public Ezra(String name, Inventory inv, Scanner sc) {
        super(name, inv, sc);
        this.relation = -1;
        loadDialogue("Resources/EzraDialogue");
    }

    /**
     * A method which returns dialogue from a switch depending on the relationship to the character.
     * @return - returns String value of specific dialogue
     */
    @Override
    public String getDialogue() {
        if (relation >= 2) {
            return positiveDialogue();
        } else if (relation <= -2) {
            return negativeDialogue();
        } else if (inv.getNotes().size() >= 3) {
            return insultOrComplimentDialogue();
        }
        return neutralDialogue();
    }

    /**
     * If the player has a bad relationship with the character, these dialogues can be activated.
     * @return - returns String value of specific dialogue
     */
    public String negativeDialogue() {
        return dialogue.get(10);
    }

    /**
     * If the player has a good relationship with the character, these dialogues can be activated.
     * @return - returns String value of specific dialogue
     */
    public String positiveDialogue() {
        switch (index2){
            case 0:
                index2++;
                return dialogue.get(8);
            case 1:
                return dialogue.get(9);
        }
        return "";
    }

    /**
     * Lets the player choose if they wish to compliment the character, insult them or give them a gift.
     * @return - returns String value of specific dialogue
     */
    public String insultOrComplimentDialogue() {
        System.out.println(dialogue.get(4));
        System.out.print("> ");
        String option = sc.next();
        switch (option) {
            case "insult":
                return dialogue.get(5);
            case "compliment":
                return dialogue.get(6);
            case "gift":
                if (inv.containsItem("Gift")) {
                    inv.removeItem("Gift");
                    return dialogue.get(7);
                }
                return "You don't have anything to give.";
            default:
                return dialogue.get(11);
        }
    }

    /**
     * Neutral dialogue that activates when the player first talks to the character or didn't progress the game enough yet.
     * @return - returns String value of specific dialogue
     */
    public String neutralDialogue() {
        switch (index1) {
            case 0:
                index1++;
                return dialogue.get(0);

            case 1:
                index1++;
                return dialogue.get(1);

            case 2:
                index1++;
                return dialogue.get(2);

            case 3:
                return dialogue.get(3);
        }
        return "";
    }



}
