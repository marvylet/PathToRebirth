package Commands;

import Map.Inventory;

/**
 * A command which is used for when the player wants to view their diary
 */
public class OpenDiary extends Command {
    private Inventory inv;

    public OpenDiary(Inventory inv) {
        this.inv = inv;
    }

    /**
     * A method which is used for listing all the obtained notes.
     * @return - returns list of notes in diary
     */
    @Override
    public String execute() {
        return inv.viewDiary();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
