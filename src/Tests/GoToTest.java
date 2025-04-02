package Tests;

import Commands.GoTo;
import Map.Inventory;
import Map.MansionMap;

import static org.junit.jupiter.api.Assertions.*;

class GoToTest {
    Inventory inv = new Inventory();
    MansionMap map = new MansionMap(inv);
    GoTo go = new GoTo(map);

    @org.junit.jupiter.api.Test
    void execute() {
        map.getLocations().get(map.getCurrentLoc()).setKeyLocked(true);
        assertEquals("Door is locked.", go.execute());

        map.getLocations().get(map.getCurrentLoc()).setMoveLocked(true);
        assertEquals("Door is locked.", go.execute());
    }



}