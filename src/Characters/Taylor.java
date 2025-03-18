package Characters;

public class Taylor extends Character{
    public Taylor(String name, int relation) {
        super(name, -1, 4);
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

    @Override
    public void addRooms() {
        rooms.add(17);
        rooms.add(6);
        rooms.add(11);
        rooms.add(20);
        rooms.add(14);
    }


}
