package Tests;

import Commands.GoTo;
import Map.Inventory;
import Map.MansionMap;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GoToTest {
    Inventory inv = new Inventory();
    Scanner sc = new Scanner(System.in);
    MansionMap map = new MansionMap(inv, sc);
    GoTo go = new GoTo(map, sc);

    @org.junit.jupiter.api.Test
    void execute() {
        map.getLocations().get(map.getCurrentLoc()).setKeyLocked(true);
        assertEquals("Door is locked.", go.execute());

        map.getLocations().get(map.getCurrentLoc()).setMoveLocked(true);
        assertEquals("Door is locked.", go.execute());
    }



}