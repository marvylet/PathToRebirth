package Commands;

import Items.Item;

public class MoveItem extends Command {
    private Item item;
    @Override
    public String execute() {
        if(item.moveable()){
            return "Item successfully moved.";
        }
        return "Not able to move the item.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
