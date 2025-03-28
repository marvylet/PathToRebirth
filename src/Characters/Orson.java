package Characters;

public class Orson extends Character {
    public Orson(String name) {
        super(name);
        this.relation = -2;
        loadDialogue("OrsonDialogue");
    }

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
