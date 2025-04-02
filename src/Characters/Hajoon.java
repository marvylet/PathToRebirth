package Characters;

import java.util.Scanner;

public class Hajoon extends Character {
    private Scanner sc;

    public Hajoon(String name) {
        super(name);
        sc = new Scanner(System.in);
        this.relation = 1;
        loadDialogue("src/Files/HajoonDialogue");
    }
    /**
     * A method which returns dialogue from a switch depending on how many times the player talks to them.
     * @return - returns String value of specific dialogue
     */
    @Override
    public String getDialogue() {
        String answer;

        System.out.println(dialogue.get(0));
        answer = sc.next();

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
