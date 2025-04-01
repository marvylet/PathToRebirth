package Commands;

import Map.MansionMap;

import java.util.Scanner;

/**
 * A command which works for when the player wants to move from one room to another.
 */
public class GoTo extends Command{

    private MansionMap map;
    private Scanner sc;

    public GoTo(MansionMap map) {
        this.map = map;
        sc = new Scanner(System.in);
    }

    /**
     * At first tells the player if the room is locked or not.
     * Afterwards lists the neighbouring rooms the player can travel to and lets them choose.
     * @return - returns either confirmation about locked door, or if the player was able to move to the room or not. Returns invalid input if an exception happens
     */
    @Override
    public String execute() {

        if(map.getLocations().get(map.getCurrentLoc()).isMoveLocked() || map.getLocations().get(map.getCurrentLoc()).isKeyLocked()){
            return "Door is locked.";
        }else {

            System.out.println("You can move to " + map.locationNames());
            String room = sc.next();

            try {
                if (map.moveToLocation(Integer.parseInt(room))) {
                    return "Moved to room.";
                } else {
                    return "Couldn't move to room.";
                }
            }catch (Exception e){
                return "Invalid input.";
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
