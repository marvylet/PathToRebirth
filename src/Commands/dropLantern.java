package Commands;

import Map.MansionMap;

/**
 * A command for dropping the lantern in the current room the player is in if they don't want it
 */
public class dropLantern extends Command{
    private MansionMap map;

    public dropLantern(MansionMap map) {
        this.map = map;
    }

    @Override
    public String execute() {
        try {
            return map.getLocations().get(map.getCurrentLoc()).removeItem("Lantern");
        }catch (Exception e){
            return "No lantern in inventory.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
