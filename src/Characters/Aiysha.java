package Characters;

public class Aiysha extends Character {
    public Aiysha(String name) {
        super(name);
        loadDialogue("Resources/AiyshaDialogue");
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
                return dialogue.get(2);
        }
        return " ";
    }



}
