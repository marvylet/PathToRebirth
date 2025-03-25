package Commands;

import Map.MansionMap;

import java.util.Scanner;

public class GoTo extends Command{

    private MansionMap map;
    private Scanner sc;

    public GoTo(MansionMap map) {
        this.map = map;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {

        if(map.getLocations().get(map.getCurrentLoc()).isMoveLocked() || map.getLocations().get(map.getCurrentLoc()).isKeyLocked()){
            return "Door is locked.";
        }else {

            System.out.println("You can move to " + map.locationNames());
            String room = sc.next();

            if (map.moveToLocation(Integer.parseInt(room))) {
                return "Moved to room.";
            } else {
                return "Couldn't move to room.";
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
