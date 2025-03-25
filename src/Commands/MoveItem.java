package Commands;


import Map.*;

import java.util.Scanner;

public class MoveItem extends Command {
    private Inventory inv;
    private MansionMap map;
    private Scanner sc;

    public MoveItem(Inventory inv, MansionMap map) {
        this.inv = inv;
        this.map = map;
        this.sc = new Scanner(System.in);
    }

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
