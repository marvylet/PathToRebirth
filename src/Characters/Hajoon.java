package Characters;

import java.util.Scanner;

public class Hajoon extends Character {
    private Scanner sc;

    public Hajoon(String name, int relation) {
        super(name, 1);
        sc = new Scanner(System.in);
    }

    @Override
    public String getDialogue() {
        String answer;

        System.out.println(dialogue.get(0));
        answer = sc.next();

        switch (answer) {
            case "yes":
                return dialogue.get(3);
            case "no":
                return dialogue.get(2);
            default:
                return dialogue.get(1);
        }

    }

    @Override
    public void addRooms() {
        rooms.add(4);
        rooms.add(17);
        rooms.add(14);
        rooms.add(18);
        rooms.add(20);
    }


}
