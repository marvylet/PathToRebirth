package Commands;

import Map.Inventory;

/**
 * A command which is used for when the player wants to view their inventory
 */
public class OpenInventory extends Command {
    private Inventory inv;

    public OpenInventory(Inventory inv) {
        this.inv = inv;
    }

    /**
     * Method used for viewing inventory
     * @return - returns list of items in inventory
     */
    @Override
    public String execute() {
        return inv.viewInventory();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
