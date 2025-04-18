package Commands;

import Items.Item;
import Items.Note;
import Map.Inventory;
import Map.MansionMap;

import java.util.Scanner;

/**
 * A command which is used for when the player wants to pick up an item
 */
public class Grab extends Command{
    private Inventory inv;
    private MansionMap map;
    private Scanner sc;

    public Grab(Inventory inv, MansionMap map, Scanner sc) {
        this.inv = inv;
        this.map = map;
        this.sc = sc;
    }

    /**
     * If there's no items in the room, tells the player
     * Afterwards lists the available items and gives player the option to choose
     * @return - returns either if the item was successfully added or if something went wrong
     */
    @Override
    public String execute() {
        try {
            if(map.getLocations().get(map.getCurrentLoc()).lightInRoom()) {
                System.out.println("Items in this room:");
                System.out.print(map.getLocations().get(map.getCurrentLoc()).viewItems());
                String s = sc.next();

                return inv.addItem(map.getLocations().get(map.getCurrentLoc()).findAndRemoveItem(s));
            }
            return "You can't see anything without a light source.";
        } catch (Exception e) {
            return "No items";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
