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
        try {
            if(map.getLocations().get(map.getCurrentLoc()).lightInRoom()) {
                System.out.println("Items in this room:");
                System.out.print(map.getLocations().get(map.getCurrentLoc()).viewItems());
                String option = sc.next();
                if (map.interactNeighboursMoveLoc()) {

                    return map.moveItemNeighbour(map.getLocations().get(map.getCurrentLoc()).findItem(option));

                } else if (map.getLocations().get(map.getCurrentLoc()).isMoveLocked()) {

                    return map.getLocations().get(map.getCurrentLoc()).moveItem(map.getLocations().get(map.getCurrentLoc()).findItem(option));
                }
                return "Failed to move item";
            }
            return "You can't see anything without a light source.";
        }catch (Exception e){
            return "Something went wrong";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
