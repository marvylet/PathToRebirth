package Characters;

public class Taylor extends Character{
    public Taylor(String name) {
        super(name);
        this.relation = -1;
        loadDialogue("TaylorDialogue");
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
                index = 0;
                return dialogue.get(1);
        }

        return "";
    }




}
