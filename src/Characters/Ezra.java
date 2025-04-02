package Characters;

public class Ezra extends Character {
    public Ezra(String name) {
        super(name);
        this.relation = -1;
        loadDialogue("Resources/EzraDialogue");
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
                return dialogue.get(3);
        }
        return "";
    }



}
