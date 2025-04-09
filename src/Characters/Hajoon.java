package Characters;

import Map.Inventory;

import java.util.Scanner;

public class Hajoon extends Character {

    public Hajoon(String name, Inventory inv, Scanner sc) {
        super(name, inv, sc);
        this.relation = 1;
        loadDialogue("Resources/HajoonDialogue");
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
        } else if (inv.getNotes().size() >= 2) {
            return insultOrComplimentDialogue();
        }
        return neutralDialogue();

    }

    /**
     * If the player has a bad relationship with the character, these dialogues can be activated.
     * @return - returns String value of specific dialogue
     */
    public String negativeDialogue() {
        switch (index3) {
            case 0:
                index3++;
                return dialogue.get(11);
            case 1:
                return dialogue.get(12);

        }
        return "";
    }

    /**
     * If the player has a good relationship with the character, these dialogues can be activated.
     *
     * @return - returns String value of specific dialogue
     */
    public String positiveDialogue() {
        System.out.println(dialogue.get(8));
        System.out.print("> ");
        String option = sc.next();
        switch (option) {
            case "hint":
                return dialogue.get(9);
            case "talk":
                return dialogue.get(10);
            default:
                return dialogue.get(1);
        }
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
                return dialogue.get(1);
        }
    }

    /**
     * Neutral dialogue that activates when the player first talks to the character or didn't progress the game enough yet.
     * This character can also give the player a hint if they agree.
     *
     * @return - returns String value of specific dialogue
     */
    public String neutralDialogue() {

        System.out.println(dialogue.get(0));
        String answer = sc.next();

        switch (answer) {
            case "yes":
                return dialogue.get(3);
            case "no":
                return dialogue.get(2);
            default:
                return dialogue.get(1);
        }
    }


}
