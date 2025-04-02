package Tests;

import Commands.Grab;
import Map.Inventory;
import Map.MansionMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrabTest {
    Inventory inv = new Inventory();
    MansionMap map = new MansionMap(inv);
    Grab grab = new Grab(inv, map);

    @Test
    void execute() {
        map.spawnRooms();


        map.getLocations().get(map.getCurrentLoc()).setItems(null);
        assertEquals("No items", grab.execute());
    }
}