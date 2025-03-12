package Commands;

import Items.Item;
import Map.Inventory;

public class Grab extends Command{
    private Inventory inv;
    private Item item;

    @Override
    public String execute() {

        if(item.isGrabbable()){
            inv.addItem(item.getName(), item);
            return "Item successfully grabbed and added in inventory.";
        }else{
            return "Item is not grabbable.";
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
