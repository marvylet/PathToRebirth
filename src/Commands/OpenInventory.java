package Commands;

import Map.Inventory;

public class OpenInventory extends Command {
    private Inventory inv;
    @Override
    public String execute() {
        return inv.viewInventory();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
