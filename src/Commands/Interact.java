package Commands;

import Map.Inventory;
import Map.MansionMap;

public class Interact extends Command{
    private Inventory inv;
    private MansionMap map;
    @Override
    public String execute() {
        if(inv.containsItem("key")){
            map.setLockedDoor(false);
            return "Door unlocked";
        }
        map.setLockedDoor(true);
        return "You don't have a key";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
