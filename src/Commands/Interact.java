package Commands;

import Map.Inventory;
import Map.MansionMap;

public class Interact extends Command{
    private Inventory inv;
    private MansionMap map;

    public Interact(Inventory inv, MansionMap map) {
        this.inv = inv;
        this.map = map;
    }

    @Override
    public String execute() {
        if(map.interactNeighbours(map.getCurrentLoc()))


        if(map.getLocations().get(map.getCurrentLoc()).isKeyLocked() || map.getLocations().get(map.getCurrentLoc()).isMoveLocked()) {

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
