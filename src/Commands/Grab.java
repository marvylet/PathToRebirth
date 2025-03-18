package Commands;

import Items.Item;
import Items.Note;
import Map.Inventory;

public class Grab extends Command{
    private Inventory inv;
    private Item item;

    //searched up "instanceof" on https://stackoverflow.com/questions/541749/how-to-determine-an-objects-class
    //as I have forgotten how exactly we wrote it
    @Override
    public String execute() {

        if(item.grabbable() && !(item instanceof Note)){
            inv.addItem(item.getName(), item);
            return "Item successfully grabbed and added in inventory.";
        }else if(item.grabbable() && item instanceof Note){
            inv.addNote(item);
            return "Note added to diary.";
        }else{
            return "Item is not grabbable.";
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
