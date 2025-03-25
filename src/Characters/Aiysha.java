package Characters;

public class Aiysha extends Character {
    public Aiysha(String name) {
        super(name);
        loadDialogue("AiyshaDialogue");
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
                return dialogue.get(2);
        }
        return " ";
    }



}
