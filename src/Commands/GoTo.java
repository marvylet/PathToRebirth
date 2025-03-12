package Commands;

import Map.MansionMap;

import java.util.Scanner;

public class GoTo extends Command{

    private MansionMap map;
    private Scanner sc;

    @Override
    public String execute() {
        map = new MansionMap();
        sc = new Scanner(System.in);

        System.out.print("You can move to " + map.locationNames());
        String room = sc.next();

        if(map.moveToLocation(Integer.parseInt(room))){
            return "Moved to room.";
        }else{
            return "Couldn't move to room, invalid parameter.";
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
