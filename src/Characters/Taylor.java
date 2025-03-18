package Characters;

public class Taylor extends Character{
    public Taylor(String name, int relation) {
        super(name, -1);
    }

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
