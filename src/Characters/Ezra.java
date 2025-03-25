package Characters;

public class Ezra extends Character {
    public Ezra(String name) {
        super(name);
        this.relation = -1;
        loadDialogue("EzraDialogue");
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
                return dialogue.get(3);
        }
        return "";
    }



}
