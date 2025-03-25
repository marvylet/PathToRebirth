package Commands;

import Map.Inventory;

public class OpenDiary extends Command {
    private Inventory inv;

    public OpenDiary(Inventory inv) {
        this.inv = inv;
    }

    @Override
    public String execute() {
        return inv.viewDiary();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
