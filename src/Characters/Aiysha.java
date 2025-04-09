package Characters;

import Items.TpPotion;
import Map.Inventory;

import java.util.Scanner;

public class Aiysha extends Character {
    public Aiysha(String name, Inventory inv, Scanner sc) {
        super(name, inv, sc);
        this.relation = 0;
        loadDialogue("Resources/AiyshaDialogue");
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
     * This specific character also offers to give the player a teleportation potion
     * @return - returns String value of specific dialogue
     */
    public String positiveDialogue() {
        TpPotion potion = new TpPotion("TpPotion", 30);
        System.out.println(dialogue.get(7));
        System.out.print("> ");
        String option = sc.next();
        switch (option) {
            case "yes":
                if (inv.freeInv() || inv.containsItem("TpPotion")) {
                    inv.addItem(potion);
                    return dialogue.get(8);
                }
                return "You don't have any space in inventory or already have a potion.";
            case "no":
                return dialogue.get(9);
            default:
                return dialogue.get(10);
        }
    }

    /**
     * Lets the player choose if they wish to compliment the character, insult them or give them a gift.
     * @return - returns String value of specific dialogue
     */
    public String insultOrComplimentDialogue() {
        System.out.println(dialogue.get(3));
        System.out.print("> ");
        String option = sc.next();
        switch (option) {
            case "insult":
                return dialogue.get(4);
            case "compliment":
                return dialogue.get(5);
            case "gift":
                if (inv.containsItem("Gift")) {
                    inv.removeItem("Gift");
                    return dialogue.get(6);
                }
                return "You don't have anything to give.";
            default:
                return dialogue.get(10);
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
                relation--;
                return dialogue.get(2);
        }
        return "";
    }


}
