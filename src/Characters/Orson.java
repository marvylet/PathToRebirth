package Characters;

public class Orson extends Character {
    public Orson(String name, int relation) {
        super(name, -2);
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

    @Override
    public void addRooms() {
        rooms.add(5);
        rooms.add(7);
        rooms.add(9);
        rooms.add(8);
        rooms.add(14);
        rooms.add(15);
        rooms.add(16);
        rooms.add(17);
    }


}
