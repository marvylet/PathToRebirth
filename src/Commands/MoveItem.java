package Commands;


import Map.*;

import java.util.Scanner;

/**
 * A command which is used when player wants to move an item
 */
public class MoveItem extends Command {
    private Inventory inv;
    private MansionMap map;
    private Scanner sc;

    public MoveItem(Inventory inv, MansionMap map, Scanner sc) {
        this.inv = inv;
        this.map = map;
        this.sc = sc;
    }

    /**
     * Checks if there are any items at all.
     * Afterwards if the room is locked, lists all available items and lets player choose which to move (if able to)
     * @return - returns if the item was moved or if the player isn't able to move that one
     */
    @Override
    public String execute() {
        if (map.getLocations().get(map.getCurrentLoc()).getItems() == null) {
            return "No items";
        }

        if (map.getLocations().get(map.getCurrentLoc()).isMoveLocked()) {

            System.out.println("Items in this room:");
            System.out.print(map.getLocations().get(map.getCurrentLoc()).viewItems());
            String s = sc.next();

            return map.getLocations().get(map.getCurrentLoc()).moveItem(map.getLocations().get(map.getCurrentLoc()).findItem(s));

        }
        return "Wasn't able to move item.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
