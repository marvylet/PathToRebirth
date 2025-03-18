package Characters;

public class Ezra extends Character {
    public Ezra(String name, int relation) {
        super(name, -1, 6);
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

    @Override
    public void addRooms() {
        rooms.add(2);
        rooms.add(10);
        rooms.add(8);
        rooms.add(17);
        rooms.add(9);
    }


}
