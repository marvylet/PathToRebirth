package Characters;

public class Aiysha extends Character {
    public Aiysha(String name) {
        super(name, 0, 5);
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

    @Override
    public void addRooms() {
        rooms.add(18);
        rooms.add(14);
        rooms.add(20);
        rooms.add(3);
        rooms.add(8);
        rooms.add(17);
    }


}
