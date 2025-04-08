package Commands;

import Map.Inventory;
import Map.MansionMap;

import java.util.Scanner;

/**
 * A method which is used if they want to unlock a door
 */
public class Interact extends Command {
    private Inventory inv;
    private MansionMap map;
    private Scanner sc;

    public Interact(Inventory inv, MansionMap map, Scanner sc) {
        this.inv = inv;
        this.map = map;
        this.sc = sc;
    }

    /**
     * If at least one of the connected rooms is locked, lists all the rooms which they can unlock. Afterwards checks if the player has a key and unlocks the door.
     * if instead the room the player is currently in is locked, checks if the player has a key and tries to unlock door.
     * @return - returns either if the door was unlocked or if something went wrong (or if player does not have a key)
     */
    @Override
    public String execute() {

        if (map.interactNeighboursKeyLoc()) {
            try {
                System.out.println("You can unlock:" + map.listKeyLockedNeighbours());
                String option = sc.next();
                if (inv.containsItem("Key")) {
                    return map.getLocations().get(Integer.parseInt(option)).unlockDoor();
                }else{
                    return "Couldn't unlock door";
                }
            } catch (Exception e) {
                return "Invalid input";
            }
        } else if (map.getLocations().get(map.getCurrentLoc()).isKeyLocked()) {

            if (inv.containsItem("Key")) {
                return map.getLocations().get(map.getCurrentLoc()).unlockDoor();
            }
            return "Couldn't unlock door.";
        }

        return "Door isn't locked.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
