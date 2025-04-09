package Tests;

import Commands.Grab;
import Map.Inventory;
import Map.MansionMap;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GrabTest {
    Inventory inv = new Inventory();
    Scanner sc = new Scanner(System.in);
    MansionMap map = new MansionMap(inv, sc);

    Grab grab = new Grab(inv, map, sc);

    @Test
    void execute() {
        map.spawnRooms();


        map.getLocations().get(map.getCurrentLoc()).setItems(null);
        assertEquals("No items", grab.execute());
    }
}