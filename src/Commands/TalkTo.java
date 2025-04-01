package Commands;

import Map.MansionMap;
import Characters.Character;

import java.util.Scanner;

/**
 * A command which is used when the player wants to talk to a character
 */
public class TalkTo extends Command {
    private Scanner sc;
    private MansionMap map;

    public TalkTo(MansionMap map) {
        this.map = map;
        sc = new Scanner(System.in);
    }

    /**
     * Method used for talking to characters. At first lists all characters in the room.
     * Afterwards lets the player choose and then returns the dialogue
     * @return - returns the character's dialogue if everything went right, otherwise returns that there isn't anyone or invalid input
     */
    @Override
    public String execute() {
        try {
            System.out.print("You can talk to:\n" + map.getLocations().get(map.getCurrentLoc()).viewChararacters());
            String s = sc.next();

            return map.getLocations().get(map.getCurrentLoc()).talkToChar(s);

        } catch (Exception e) {
            return "Nobody to talk to.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
