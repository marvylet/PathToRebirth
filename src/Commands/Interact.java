package Commands;

import Map.Inventory;
import Map.MansionMap;

import java.util.Scanner;

public class Interact extends Command {
    private Inventory inv;
    private MansionMap map;
    private Scanner sc;

    public Interact(Inventory inv, MansionMap map) {
        this.inv = inv;
        this.map = map;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {

        if (map.interactNeighbours()) {
            try {
                System.out.println("You can unlock:" + map.listLockedNeighbours());
                String option = sc.next();
                return map.getLocations().get(Integer.parseInt(option)).unlockDoor();
            } catch (Exception e) {
                return "Invalid input";
            }
        } else if (map.getLocations().get(map.getCurrentLoc()).isKeyLocked() || map.getLocations().get(map.getCurrentLoc()).isMoveLocked()) {

            if (inv.containsItem("Key")) {
                return map.getLocations().get(map.getCurrentLoc()).unlockDoor();
            }
            return "Couldn't unlock door.";
        }

        return "Door isn't locked.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
